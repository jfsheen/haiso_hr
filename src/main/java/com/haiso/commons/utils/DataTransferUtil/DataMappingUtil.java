package com.haiso.commons.utils.DataTransferUtil;

import com.haiso.commons.utils.ClassUtilV2;
import com.haiso.commons.utils.ExcelReaderV2;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * Created by ff on 5/5/14.
 */
public final class DataMappingUtil {

    private static Set<Class<?>> entitySet = ClassUtilV2.getClassesAnnotated("com.haiso.hr.entity", Entity.class);
    ;
    private static Set<Class<?>> embeddableSet = ClassUtilV2.getClassesAnnotated("com.haiso.hr.entity", Embeddable.class);
    private static String DATAMAPPING_XML_PATH = null;
    private static ExcelReaderV2 excelReaderV2 = new ExcelReaderV2();

    private static String getFullyQualifiedClassName(Set<Class<?>> classSet, String className) {
        for (Class c : classSet) {
            String cname = c.getName();
            if (cname.substring(cname.lastIndexOf(".") + 1).equals(className)) {
                return cname;
            }
        }
        return null;
    }

    public static void getXmlFieldsMapping(String filePath) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(filePath));
        Element root = document.getRootElement();
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            //未知属性名称情况下
            Iterator attrIt = element.attributeIterator();
            while (attrIt.hasNext()) {
                Attribute a = (Attribute) attrIt.next();
                System.out.println(a.getValue());
            }
            //已知属性名称情况下
//            System.out.println("id: " + element.attributeValue("id"));

            //未知元素名情况下
            Iterator eleIt = element.elementIterator();
            while (eleIt.hasNext()) {
                Element e = (Element) eleIt.next();
                System.out.println(e.getName() + ": " + e.getText());
            }
            System.out.println();
            //已知元素名情况下
            /*System.out.println("title: " + element.elementText("title"));
            System.out.println("author: " + element.elementText("author"));
            System.out.println();*/
        }
    }

    public static String getXmlDataMappingFromHashcode(String path, String fileName) throws Exception {
        return getXmlDataMappingFromHashcode(new File(path, fileName));
    }

    public static String getXmlDataMappingFromHashcode(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        return root.attributeValue("from");
    }

    public static String getXmlDataMappingToHashcode(String path, String fileName) throws Exception {
        return getXmlDataMappingToHashcode(new File(path, fileName));
    }

    public static String getXmlDataMappingToHashcode(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        return root.attributeValue("to");
    }


    public static Map<String, Integer> readXmlDataMapping(String className) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(DATAMAPPING_XML_PATH, className + ".xml"));
        Element root = document.getRootElement();
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
        }

        return null;
    }


    public static void writeXmlDataMapping(String className, Map<String, String> mapFrom, Map<String, String> mapTo, String path)
            throws Exception {
        Document doc = DocumentHelper.createDocument();
        //增加根节点
        Element root = doc.addElement(className);
        root.addAttribute("from", ((Integer) mapFrom.hashCode()).toString());
        root.addAttribute("to", ((Integer) mapTo.hashCode()).toString());
        Set<String> mapFromKeys = mapFrom.keySet();
        //增加子元素
        Iterator it = mapTo.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Element field = root.addElement("property");
            field.addAttribute("name", (String) entry.getKey());
            //添加元素&内容
            Element value = field.addElement("value");
            value.addAttribute("index", (mapFromKeys.contains(entry.getValue())) ? (String) entry.getValue() : "");
            value.addAttribute("title", (mapFromKeys.contains(entry.getValue())) ? mapFrom.get(entry.getValue()) : "");
        }
        //实例化输出格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置输出编码
        format.setEncoding("UTF-8");
        //创建需要写入的File对象
        //TODO  file name
        String fileName = className + ".xml";
        File file = new File(path, fileName);
        //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        //开始写入，write方法中包含上面创建的Document对象
        writer.write(doc);
    }


    public static Map<String, String> getDatasSourceSheetTitles(String fileName, Integer sheetIndex, Integer titleRowIndex) throws IOException {
        return excelReaderV2.listSheetTitles(excelReaderV2.getSheet(excelReaderV2.createWb(fileName), sheetIndex), titleRowIndex);
    }

    public static String getDataSourceSheetTitlesMapHashcode(String fileName, Integer sheetIndex, Integer titleRowIndex) throws Exception {
        return ((Integer) getDatasSourceSheetTitles(fileName, sheetIndex, titleRowIndex).hashCode()).toString();
    }

    public static Set<String> getEntityFields(String className) {
        Set<String> fields = new TreeSet<String>();
        String fullyQualifiedClassName = getFullyQualifiedClassName(entitySet, className);
        if (!fullyQualifiedClassName.isEmpty()) {
            Set<Field> entityFieldSet = ClassUtilV2.getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
            for (Field f : entityFieldSet) {
                fields.add(f.getName());
//                System.out.println("basic field = " + f.getName());
            }
            Set<Field> embeddedSet = ClassUtilV2.getFieldsAnnotated(fullyQualifiedClassName, Embedded.class);
            for (Field es : embeddedSet) {
//                System.out.println("embedded class = " + es.getType().getName());
                Set<Field> embeddedFieldSet = ClassUtilV2.getFieldsAnnotated(es.getType().getName(), Basic.class);
                for (Field efs : embeddedFieldSet) {
                    fields.add(efs.getName());
//                    System.out.println("embedded field = " + efs.getName());
                }
            }
        }
        return fields;
    }

}
