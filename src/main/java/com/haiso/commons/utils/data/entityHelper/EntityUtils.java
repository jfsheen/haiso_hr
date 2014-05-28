package com.haiso.commons.utils.data.entityHelper;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by ff on 5/12/14.
 */
public final class EntityUtils {

    public static Set<Class<?>> getClassesAnnotated(String packageName, Class<? extends java.lang.annotation.Annotation> annotation) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getTypesAnnotatedWith(annotation);
    }

    public static Set<Field> getFieldsAnnotated(String packageName, String className, Class<? extends java.lang.annotation.Annotation> annotation) {
        Reflections reflections = new Reflections(packageName + "." + className, new FieldAnnotationsScanner());
        return reflections.getFieldsAnnotatedWith(annotation);
    }

    public static Set<Field> getFieldsAnnotated(String fullyQualifiedClassName, Class<? extends java.lang.annotation.Annotation> annotation) {
        Reflections reflections = new Reflections(fullyQualifiedClassName, new FieldAnnotationsScanner());
        return reflections.getFieldsAnnotatedWith(annotation);
    }
}
