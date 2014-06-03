package com.haiso.commons.utils.data.entityHelper;

import com.haiso.commons.constant.CommonsConstant;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ff on 5/12/14.
 */
public final class EntityUtils {

    private String entityPkg = CommonsConstant.ENTITY_PACKAGE;
    private Set<Class<?>> entitySet = getClassesAnnotated(entityPkg, Entity.class);
    private Set<Class<?>> embeddableSet = getClassesAnnotated(entityPkg, Embeddable.class);
    
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


    private String getFullyQualifiedClassName(Set<Class<?>> classSet, String className) {
        for (Class c : classSet) {
            String cname = c.getName();
            if (cname.substring(cname.lastIndexOf(".") + 1).equals(className)) {
                return cname;
            }
        }
        return null;
    }

    public Set<String> getEmbeddedFields(String className) {
        Set<String> fields = new TreeSet<String>();
        String fullyQualifiedClassName = getFullyQualifiedClassName(embeddableSet, className);
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
        String fullyQualifiedClassName = getFullyQualifiedClassName(entitySet, className);
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
    //  return map(entityHelper name, entityHelper type)
    public Map<String, String> getEntityFiledsMap(String className){
        Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

        String fullyQualifiedClassName = getFullyQualifiedClassName(entitySet, className);
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
