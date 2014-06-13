package com.haiso.commons.utils.data.entityHelper;

import com.google.common.collect.Sets;
import com.haiso.commons.constant.CommonsConstant;
import com.haiso.commons.utils.data.entityHelper.vo.EntityField;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by ff on 5/12/14.
 */
public final class EntityUtils {

    private String entityPackage = CommonsConstant.ENTITY_PACKAGE;
    private Set<Class<?>> entitySet = getClassesAnnotated(entityPackage, Entity.class);
    private Set<Class<?>> embeddableSet = getClassesAnnotated(entityPackage, Embeddable.class);
    
    private Set<Class<?>> getClassesAnnotated(String packageName, Class<? extends java.lang.annotation.Annotation> annotation) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getTypesAnnotatedWith(annotation);
    }

    private Set<Field> getFieldsAnnotated(String packageName, String className, Class<? extends java.lang.annotation.Annotation> annotation) {
        Reflections reflections = new Reflections(packageName + "." + className, new FieldAnnotationsScanner());
        return reflections.getFieldsAnnotatedWith(annotation);
    }

    private Set<Field> getFieldsAnnotated(String fullyQualifiedClassName, Class<? extends java.lang.annotation.Annotation> annotation) {
        Reflections reflections = new Reflections(fullyQualifiedClassName, new FieldAnnotationsScanner());
        return reflections.getFieldsAnnotatedWith(annotation);
    }


    private String getFullyQualifiedClassName(String className) {
        Set<Class<?>> classSet = Sets.newHashSet(CollectionUtils.union(entitySet, embeddableSet));
        for (Class c : classSet) {
            if (c.getSimpleName().equals(className)) {
                return c.getName();
            }
        }
        return null;
    }

    /*public Set<Object> getEntityFields(String className){

    }*/

    public Set<String> getEmbeddedFields(String className) {
        Set<String> fields = new TreeSet<String>();
        String fullyQualifiedClassName = getFullyQualifiedClassName(className);
        if (!fullyQualifiedClassName.isEmpty() && fullyQualifiedClassName != null) {
            Set<Field> fieldSet = getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
            for (Field f : fieldSet) {
                fields.add(f.getName());
            }
        }
        return fields;
    }

    public Set<String> getEntityFields(String className) {
        Set<String> fields = new TreeSet<String>();
        String fullyQualifiedClassName = getFullyQualifiedClassName(className);
        if (!fullyQualifiedClassName.isEmpty() && fullyQualifiedClassName != null) {
            Set<Field> entityFieldSet = getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
            for (Field f : entityFieldSet) {
                fields.add(f.getName());
            }
            Set<Field> embeddedSet = getFieldsAnnotated(fullyQualifiedClassName, Embedded.class);
            for (Field es : embeddedSet) {
                Set<Field> embeddedFieldSet = getFieldsAnnotated(es.getType().getName(), Basic.class);
                for (Field efs : embeddedFieldSet) {
                    fields.add(efs.getName());
                }
            }
        }
        return fields;
    }

    public EntityField traverseEntity(String entityName, EntityField entityField){
        /*if(entityField == null){
        EntityField entityField = new EntityField();
        }*/
        String fullyQualifiedClassName = getFullyQualifiedClassName(entityName);
        Set<Field> embeddedFieldSet = null;
        Set<Field> basicFieldSet = null;
        if (fullyQualifiedClassName != null) {
            entityField.setFieldType(fullyQualifiedClassName);
            entityField.setDescription(entityName);
            embeddedFieldSet = getFieldsAnnotated(fullyQualifiedClassName, Embedded.class);
            basicFieldSet = getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
            for(Field field : basicFieldSet){
                entityField.getEmbeddedFields().add(new EntityField(field.getType().getName(), field.getName(), field.getName(), null));
            }
            for(Field field : embeddedFieldSet){
                entityField.addEmbeddedField(traverseEntity(field.getType().getSimpleName(), new EntityField(field.getName())));//todo logic error
            }
        }
        return entityField;
    }
    /*
    public void traverseEntity(String entityName, FieldNode fieldNode){
        String fullyQualifiedClassName = getFullyQualifiedClassName(entityName);
        String fieldName = entityName;
        Set<Field> embeddedFieldSet = null;
        Set<Field> basicFieldSet = null;
        if (fullyQualifiedClassName != null) {
            embeddedFieldSet = getFieldsAnnotated(fullyQualifiedClassName, Embedded.class);
            basicFieldSet = getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
//            fieldNode.setParentField(null);
            fieldNode.setFieldName(entityName);
            fieldNode.setFieldSet(basicFieldSet);
            System.out.println(fieldName);
            System.out.println(Arrays.toString(basicFieldSet.toArray()));
            if(!embeddedFieldSet.isEmpty()){
                for(Field field : embeddedFieldSet){
                    FieldNode fieldNode1 = new FieldNode();
                    fieldNode1.setParentNode(fieldNode);
                    traverseEntity(field.getType().getSimpleName(), fieldNode1);
                }
            }
        }
    }*/

    public String getJsonEntityFields(String className){
        Set<String> fields = new TreeSet<String>();
        ObjectMapper mapper = new ObjectMapper();
        String fullyQualifiedClassName = getFullyQualifiedClassName(className);
        if (fullyQualifiedClassName != null) {
            Set<Field> entityFieldSet = null;
            while (!(entityFieldSet = getFieldsAnnotated(fullyQualifiedClassName, Embedded.class)).isEmpty()){
//                fullyQualifiedClassName =
                for (Field f : entityFieldSet) {
                    fields.add(f.getName());
                }
            }


        }
        String res = null;
        try {
            res = mapper.writeValueAsString(fields);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    //  return map(entityHelper name, entityHelper type)
    public Map<String, String> getEntityFiledsMap(String className){
        Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

        String fullyQualifiedClassName = getFullyQualifiedClassName(className);
        if (!fullyQualifiedClassName.isEmpty()) {
            Set<Field> entityFieldSet = getFieldsAnnotated(fullyQualifiedClassName, Basic.class);
            for (Field f : entityFieldSet) {
                fieldsMap.put(f.getName(), f.getGenericType().toString());
            }
            Set<Field> embeddedSet = getFieldsAnnotated(fullyQualifiedClassName, Embedded.class);
            for (Field es : embeddedSet) {
                Set<Field> embeddedFieldSet = getFieldsAnnotated(es.getType().getName(), Basic.class);
                for (Field efs : embeddedFieldSet) {
                    fieldsMap.put(efs.getName(), efs.getGenericType().toString());
                }
            }
        }
        return fieldsMap;
    }
}
