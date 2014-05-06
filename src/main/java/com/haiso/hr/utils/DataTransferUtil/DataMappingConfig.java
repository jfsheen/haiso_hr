package com.haiso.hr.utils.DataTransferUtil;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by ff on 5/5/14.
 */
public final class DataMappingConfig {

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

    public static void setFieldsMapping(Map<Map<String, String>, Map<String, String>> map, String filePath) {

    }


    public static void setXmlFieldsMapping(Class clazz, String filePath) throws Exception {
        Map<String, String> fields = getClassFields(clazz);
        Document doc = DocumentHelper.createDocument();
        //增加根节点
        Element root = doc.addElement(clazz.getName());
        //增加子元素
        Iterator it = fields.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Element field = root.addElement("property");
            field.addAttribute("type", entry.getValue().toString());
            field.addAttribute("name", entry.getKey().toString());
            //添加元素&内容
            Element excel = field.addElement("excel");
            excel.addAttribute("title", "");
            excel.addAttribute("index", "");
        }
        //实例化输出格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置输出编码
        format.setEncoding("UTF-8");
        //创建需要写入的File对象
        File file = new File(filePath);
        //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        //开始写入，write方法中包含上面创建的Document对象
        writer.write(doc);
    }


    public static Map<String, String> getEntityFields(Class clazz) {
        Map<String, String> fieldsMap = new HashMap<String, String>();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            List<String> ignorFields = new ArrayList<String>();
            ignorFields.add("id");
            ignorFields.add("lastUpdate");
            ignorFields.add("createDate");
            ignorFields.add("version");
            if (!ignorFields.contains(fields[i].getName())) {
                String regEx = "com.haiso.hr.entity.*";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(fields[i].getType().toString());
                if (!matcher.find()) {
                }
                try {
                    Class c = Class.forName(fields[i].getType().getName());
                    Annotation[] annotations = c.getAnnotations();
                    if (annotations.length > 0) {
                        //TODO
                        //too ugly code
                        if (annotations[0].toString().equals("@javax.persistence.Embeddable()")) {
                            System.out.println(fields[i].getType().getName());
                            //Map<String, String> fieldsMap = new HashMap<String, String>();
                            Field[] fields2 = c.getDeclaredFields();
                            for (int i2 = 0, len2 = fields2.length; i2 < len2; i2++) {
                                fieldsMap.put(fields2[i2].getName(), fields2[i2].getType().toString());
                            }
                        }
                    }
                    // continue;
                } catch (ClassNotFoundException e) {
                    System.out.println("-" + i + "-");
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                fieldsMap.put(fields[i].getName(), fields[i].getType().toString());
            }
        }
        return fieldsMap;
    }

    private static Map<String, String> getClassFields(Class c) {
        Map<String, String> fieldsMap = new HashMap<String, String>();
        Field[] fields = c.getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            fieldsMap.put(fields[i].getName(), fields[i].getType().toString());
        }
        return fieldsMap;
    }
}
