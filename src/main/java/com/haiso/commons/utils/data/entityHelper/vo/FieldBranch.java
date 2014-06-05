package com.haiso.commons.utils.data.entityHelper.vo;

import java.util.List;

/**
 * Created by ff on 6/5/14.
 */
public class FieldBranch {
    private FieldNode node;
    private List<FieldBranch> fieldBranchList;

    public FieldNode getNode() {
        return node;
    }

    public void setNode(FieldNode node) {
        this.node = node;
    }

    public List<FieldBranch> getFieldBranchList() {
        return fieldBranchList;
    }

    public void setFieldBranchList(List<FieldBranch> fieldBranchList) {
        this.fieldBranchList = fieldBranchList;
    }
}
