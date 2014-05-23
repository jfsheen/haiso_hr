package com.haiso.commons.utils.data;

import com.haiso.commons.utils.data.fieldHelper.ClassUtil;
import com.haiso.commons.utils.data.excelHelper.ExcelReader;
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
import java.util.*;


/**
 * Created by ff on 5/5/14.
 */
public final class DataMappingUtil {

    private static Set<Class<?>> entitySet = ClassUtil.getClassesAnnotated("com.haiso.hr.entity", Entity.class);
    ;
    private static Set<Class<?>> embeddableSet = ClassUtil.getClassesAnnotated("com.haiso.hr.entity", Embeddable.class);
    private static String DATAMAPPING_XML_PATH = null;
    private static ExcelReader excelReader = new ExcelReader();

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

    public static String getXmlDataMappingFromHashcode(String filePath) throws Exception {
        return getXmlDataMappingFromHashcode(new File(filePath));
    }

    public static String getXmlDataMappingFromHashcode(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        return root.attributeValue("from");
    }

    public static String getXmlDataMappingToHashcode(String filePath) throws Exception {
        return getXmlDataMappingToHashcode(new File(filePath));
    }

    public static String getXmlDataMappingToHashcode(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        return root.attributeValue("to");
    }

    public static Map<String, String> readXmlSimpleDataMapping(String filePath) throws DocumentException{
        return readXmlSimpleDataMapping(new File(filePath));
    }
    public static Map<String, String> readXmlSimpleDataMapping(String path, String fileName) throws DocumentException{
        return readXmlSimpleDataMapping(new File(path,fileName));
    }

    public static Map<String, String> readXmlSimpleDataMapping(File file) throws DocumentException{
        Map<String, String[]> map = readXmlDataMapping(file);
        Map<String,String> mapping = new LinkedHashMap<String, String>();
        for(Map.Entry<String, String[]> entry : map.entrySet()){
            mapping.put(entry.getKey(), entry.getValue()[1]);
        }
        return mapping;
    }

    public static Map<String, String[]> readXmlDataMapping(String filePath) throws DocumentException {
        return readXmlDataMapping(new File(filePath));

    }
    public static Map<String, String[]> readXmlDataMapping(String path, String fileName) throws DocumentException {
        return readXmlDataMapping(new File(path, fileName));
    }
    public static Map<String, String[]> readXmlDataMapping(File file) throws DocumentException {
        Map<String, String[]> mapping = new LinkedHashMap<String, String[]>();
        Map<String, ArrayList<String>> map = readXmlDataMappingA(file);
        for( Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            mapping.put(entry.getKey(),entry.getValue().toArray(new String[entry.getValue().size()]));
        }
        return mapping;
    }

    /*private static Mapping readXmlDataMappingB(File file) throws DocumentException{
        Mapping mapping = new Mapping();

        return mapping;
    }*/

    private static Map<String, ArrayList<String>> readXmlDataMappingA(File file) throws DocumentException {
        Map<String, ArrayList<String>> mapping = new LinkedHashMap<String, ArrayList<String>>();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            String name = element.attributeValue("name");
            String index = element.element("value").attributeValue("index");
            String title = element.element("value").attributeValue("title");
            ArrayList<String> list = new ArrayList<String>();
            list.add(index);
            list.add(title);
            mapping.put(name, list);
        }
        return mapping;
    }

/*    public static Boolean writeXmlDataMapping(Mapping mapping){

        return false;
    }*/

    public static Boolean writeXmlDataMapping(String className, Map<String, String> mapFrom, Map<String, String> mapTo, String path)
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
        try{
            //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            //开始写入，write方法中包含上面创建的Document对象
            writer.write(doc);
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static Map<String, String> getDataSourceSheetTitlesMap(String filePath, Integer sheetIndex, Integer titleRowIndex) throws IOException {
        return excelReader.listSheetTitles(filePath, sheetIndex, titleRowIndex);
    }

    public static Map<String, String> getDataSourceSheetTitlesMap(File file, Integer sheetIndex, Integer titleRowIndex) throws IOException {
        return excelReader.listSheetTitles(file, sheetIndex, titleRowIndex);
    }


    public static String getDataSourceSheetTitlesMapHashcode(String filePath, Integer sheetIndex, Integer titleRowIndex) throws Exception {
        return ((Integer) getDataSourceSheetTitlesMap(filePath, sheetIndex, titleRowIndex).hashCode()).toString();
    }

    public static String getDataSourceSheetTitlesMapHashcode(File file, Integer sheetIndex, Integer titleRowIndex) throws Exception {
        return ((Integer) getDataSourceSheetTitlesMap(file, sheetIndex, titleRowIndex).hashCode()).toString();
    }

    //  return map(fieldHelper name, fieldHelper type)
    public static Map<String, String> getEntityFiledsMap(String className){
        Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

        String fullyQualifiedClassName = getFullyQualifiedClassName(entitySet, className);
        if (!fullyQualifiedClassName.isEmpty()) {
            Set<Field> entityFieldSet = ClassUtil.getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
            for (Field f : entityFieldSet) {
                fieldsMap.put(f.getName(), f.getGenericType().toString());
            }
            Set<Field> embeddedSet = ClassUtil.getFieldsAnnotated(fullyQualifiedClassName, Embedded.class);
            for (Field es : embeddedSet) {
                Set<Field> embeddedFieldSet = ClassUtil.getFieldsAnnotated(es.getType().getName(), Basic.class);
                for (Field efs : embeddedFieldSet) {
                    fieldsMap.put(efs.getName(), efs.getGenericType().toString());
                }
            }
        }
        return fieldsMap;
    }

    public static Set<String> getEntityFields(String className) {
        Set<String> fields = new TreeSet<String>();
        String fullyQualifiedClassName = getFullyQualifiedClassName(entitySet, className);
        if (!fullyQualifiedClassName.isEmpty()) {
            Set<Field> entityFieldSet = ClassUtil.getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
            for (Field f : entityFieldSet) {
                fields.add(f.getName());
            }
            Set<Field> embeddedSet = ClassUtil.getFieldsAnnotated(fullyQualifiedClassName, Embedded.class);
            for (Field es : embeddedSet) {
                Set<Field> embeddedFieldSet = ClassUtil.getFieldsAnnotated(es.getType().getName(), Basic.class);
                for (Field efs : embeddedFieldSet) {
                    fields.add(efs.getName());
                }
            }
        }
        return fields;
    }
}
