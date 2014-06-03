package com.haiso.hr.entity;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ff on 4/15/14.
 * 部门表
 */
@Entity
@Table(name = "t_department")
public class Department extends AuditBaseEntity{

    @Column(name = "dept_sn")
    private String deptSn;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "duty")
    private String duty;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "is_child")
    private Boolean isChild;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_dept")
    private Department parentDept;
    @OneToMany(mappedBy = "parentDept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "child_dept")
    private Set<Department> childDept;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("deptSn", deptSn)
                .add("name", name)
                .add("duty", duty)
                .add("description", description)
                .add("isChild", isChild)
                .add("parentDept", parentDept)
                .add("childDept", childDept)
                .toString();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(deptSn, name, duty, description, isChild, parentDept, childDept);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final Department other = (Department) obj;
        return Objects.equal(this.deptSn, other.deptSn) && Objects.equal(this.name, other.name) && Objects.equal(this.duty, other.duty) && Objects.equal(this.description, other.description) && Objects.equal(this.isChild, other.isChild) && Objects.equal(this.parentDept, other.parentDept) && Objects.equal(this.childDept, other.childDept);
    }

    public String getDeptSn() {

        return deptSn;
    }

    public void setDeptSn(String deptSn) {
        this.deptSn = deptSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsChild() {
        return isChild;
    }

    public void setIsChild(Boolean isChild) {
        this.isChild = isChild;
    }

    public Department getParentDept() {
        return parentDept;
    }

    public void setParentDept(Department parentDept) {
        this.parentDept = parentDept;
    }

    public Set<Department> getChildDept() {
        return childDept;
    }

    public void setChildDept(Set<Department> childDept) {
        this.childDept = childDept;
    }
}
