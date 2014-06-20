package com.haiso.hr.entity.organization;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 岗位表
 */
@Entity
@Table(name = "t_position")
public class Position extends AuditBaseEntity{

    @Basic
    @Column(name = "post_sn")
    private String postSn;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "post_sequence")
    private Byte postSeq;
    @Basic
    @Column(name = "amount_limit")
    private Byte amountLimit;
    @Basic
    @Column(name = "post_duty")
    private String postDuty;
    @Basic
    @Column(name = "remark")
    private String remark;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    public String getPostSn() {
        return postSn;
    }

    public void setPostSn(String postSn) {
        this.postSn = postSn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getPostSeq() {
        return postSeq;
    }

    public void setPostSeq(Byte postSeq) {
        this.postSeq = postSeq;
    }

    public Byte getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(Byte amountLimit) {
        this.amountLimit = amountLimit;
    }

    public String getPostDuty() {
        return postDuty;
    }

    public void setPostDuty(String postDuty) {
        this.postDuty = postDuty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(postSn, title, postSeq, amountLimit, postDuty, remark, department);
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
        final Position other = (Position) obj;
        return Objects.equal(this.postSn, other.postSn) && Objects.equal(this.title, other.title) && Objects.equal(this.postSeq, other.postSeq) && Objects.equal(this.amountLimit, other.amountLimit) && Objects.equal(this.postDuty, other.postDuty) && Objects.equal(this.remark, other.remark) && Objects.equal(this.department, other.department);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("postSn", postSn)
                .add("title", title)
                .add("postSeq", postSeq)
                .add("amountLimit", amountLimit)
                .add("postDuty", postDuty)
                .add("remark", remark)
                .add("department", department)
                .toString();
    }

}
