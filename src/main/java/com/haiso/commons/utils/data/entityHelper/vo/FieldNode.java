package com.haiso.commons.utils.data.entityHelper.vo;

import java.util.Map;

/**
 * Created by ff on 6/6/14.
 */
public class FieldNode {
    private String fieldName;
    private String fieldType;
    private String description;
    private FieldNode parentField;
    private Map<String, String> embeddedFields;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FieldNode getParentField() {
        return parentField;
    }

    public void setParentField(FieldNode parentField) {
        this.parentField = parentField;
    }

    public Map<String, String> getEmbeddedFields() {
        return embeddedFields;
    }

    public void setEmbeddedFields(Map<String, String> embeddedFields) {
        this.embeddedFields = embeddedFields;
    }
}
