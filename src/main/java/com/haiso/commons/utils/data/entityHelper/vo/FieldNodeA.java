package com.haiso.commons.utils.data.entityHelper.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 6/5/14.
 */
public class FieldNodeA {
    private String fieldName;
    private String fieldType;
    private String description;
    private FieldNode parentField;
    private List<FieldNode> embeddedFields;


    public FieldNodeA() {
        initEmbeddedFields();
    }

    public void initEmbeddedFields(){
        if(embeddedFields == null){
            embeddedFields = new ArrayList<FieldNode>();
        }
    }

    /* 插入一个child节点到当前节点中 */
    public void addEmbeddedField(FieldNode fieldNodeA) {
        initEmbeddedFields();
        embeddedFields.add(fieldNode);
    }

    /* 返回当前节点的父辈节点集合 */
    public List<FieldNode> getElders() {
        List<FieldNode> elderList = new ArrayList<FieldNode>();
        FieldNode fieldNodeA = this.getParentField();
        if (fieldNode == null) {
            return elderList;
        } else {
            elderList.add(fieldNode);
            elderList.addAll(fieldNode.getElders());
            return elderList;
        }
    }

    /* 返回当前节点的晚辈集合 */
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

    /* 返回当前节点的孩子集合 */
/*    public List<FieldNodeA> getChildList() {
        return childList;
    }*/

    /* 删除节点和它下面的晚辈 */
    public void deleteNode() {
        FieldNode parentField = this.getParentField();
        String fieldName = parentField.getFieldName();
        if (parentField != null) {
            parentField.deleteChildNode(fieldName);
        }
    }

    /* 删除当前节点的某个子节点 */
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
    }

    /* 动态的插入一个新的节点到当前树中 */
    /*public boolean insertJuniorNode(FieldNodeA fieldNodeA) {
        String juniorFieldName = fieldNodeA.getFieldName();
        if (this.parentId == juniorParentId) {
            addChildNode(treeNode);
            return true;
        } else {
            List<FieldNodeA> childList = this.getChildList();
            int childNumber = childList.size();
            boolean insertFlag;

            for (int i = 0; i < childNumber; i++) {
                FieldNodeA childNode = childList.get(i);
                insertFlag = childNode.insertJuniorNode(treeNode);
                if (insertFlag == true)
                    return true;
            }
            return false;
        }
    }

    *//* 找到一颗树中某个节点 *//*
    public FieldNodeA findFieldNodeById(int id) {
        if (this.selfId == id)
            return this;
        if (childList.isEmpty() || childList == null) {
            return null;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                FieldNodeA child = childList.get(i);
                FieldNodeA resultNode = child.findFieldNodeById(id);
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
            FieldNodeA child = childList.get(i);
            child.traverse();
        }
    }*/

    public FieldNode getParentField() {
        return parentField;
    }

    public void setParentField(FieldNode parentField) {
        this.parentField = parentField;
    }

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
