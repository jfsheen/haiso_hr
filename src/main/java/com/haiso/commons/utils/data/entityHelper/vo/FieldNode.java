package com.haiso.commons.utils.data.entityHelper.vo;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 6/5/14.
 */
public class FieldNode {
    private String fieldName;
    private String fieldType;
    private String description;
    private List<FieldNode> embeddedFields;


    public FieldNode(String fieldType, String fieldName, String description, List<FieldNode> embeddedFields) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.description = description;
        this.embeddedFields = embeddedFields;
    }

    public FieldNode() {
        initEmbeddedFields();
    }

    public void initEmbeddedFields(){
        if(embeddedFields == null){
            embeddedFields = new ArrayList<FieldNode>();
        }
    }
    public FieldNode(String fieldName) {
        initEmbeddedFields();
        this.fieldName = fieldName;
    }

    public void addEmbeddedField(FieldNode fieldNode) {
        List<FieldNode> list = this.getEmbeddedFields();
        list.add(fieldNode);
        this.setEmbeddedFields(list);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("fieldName", fieldName)
                .add("fieldType", fieldType)
                .add("description", description)
                .add("embeddedFields", embeddedFields)
                .toString();
    }

    /* 插入一个child节点到当前节点中 *//*
    public void addEmbeddedField(FieldNode fieldNode) {
        initEmbeddedFields();
        embeddedFields.add(fieldNode);
    }

    *//* 返回当前节点的父辈节点集合 *//*
    public List<FieldNode> getElders() {
        List<FieldNode> elderList = new ArrayList<FieldNode>();
        FieldNode fieldNode = this.getParentField();
        if (fieldNode == null) {
            return elderList;
        } else {
            elderList.add(fieldNode);
            elderList.addAll(fieldNode.getElders());
            return elderList;
        }
    }

    *//* 返回当前节点的晚辈集合 *//*
    public List<FieldNode> getJuniors() {
        List<FieldNode> juniorList = new ArrayList<FieldNode>();
        List<FieldNode> embeddedFields = this.getEmbeddedFields();
        if (embeddedFields == null) {
            return juniorList;
        } else {
            int childNumber = embeddedFields.size();
            for (int i = 0; i < childNumber; i++) {
                FieldNode junior = embeddedFields.get(i);
                juniorList.add(junior);
                juniorList.addAll(junior.getJuniors());
            }
            return juniorList;
        }
    }

    *//* 返回当前节点的孩子集合 *//*
*//*    public List<FieldNode> getChildList() {
        return childList;
    }*//*

    *//* 删除节点和它下面的晚辈 *//*
    public void deleteNode() {
        FieldNode parentField = this.getParentField();
        String fieldName = parentField.getFieldName();
        if (parentField != null) {
            parentField.deleteChildNode(fieldName);
        }
    }

    *//* 删除当前节点的某个子节点 *//*
    public void deleteChildNode(String fieldName) {
        List<FieldNode> embeddedFields = this.getEmbeddedFields();
        int num = embeddedFields.size();
        for (int i = 0; i < num; i++) {
            FieldNode embeddedField = embeddedFields.get(i);
            if (embeddedField.getFieldName() == fieldName) {
                embeddedFields.remove(i);
                return;
            }
        }
    }*/

    /* 动态的插入一个新的节点到当前树中 */
    /*public boolean insertJuniorNode(FieldNode fieldNode) {
        String juniorFieldName = fieldNode.getFieldName();
        if (this.parentId == juniorParentId) {
            addChildNode(treeNode);
            return true;
        } else {
            List<FieldNode> childList = this.getChildList();
            int childNumber = childList.size();
            boolean insertFlag;

            for (int i = 0; i < childNumber; i++) {
                FieldNode childNode = childList.get(i);
                insertFlag = childNode.insertJuniorNode(treeNode);
                if (insertFlag == true)
                    return true;
            }
            return false;
        }
    }

    *//* 找到一颗树中某个节点 *//*
    public FieldNode findFieldNodeById(int id) {
        if (this.selfId == id)
            return this;
        if (childList.isEmpty() || childList == null) {
            return null;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                FieldNode child = childList.get(i);
                FieldNode resultNode = child.findFieldNodeById(id);
                if (resultNode != null) {
                    return resultNode;
                }
            }
            return null;
        }
    }

    *//* 遍历一棵树，层次遍历 *//*
    public void traverse() {
        if (selfId < 0)
            return;
        print(this.selfId);
        if (childList == null || childList.isEmpty())
            return;
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            FieldNode child = childList.get(i);
            child.traverse();
        }
    }*/

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public List<FieldNode> getEmbeddedFields() {
        return embeddedFields;
    }

    public void setEmbeddedFields(List<FieldNode> embeddedFields) {
        this.embeddedFields = embeddedFields;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
