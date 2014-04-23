package com.haiso.hr.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 * 员工工资调整记录
 */
@Entity
@Table(name = "t_empl_salary_adjust")
public class EmplSalaryAdjustment {

    private int id;
    private int amount; //单位为:分
    private String remark; //备注，必填
    private Date timeAdjust;
    private int version;

    @Version
    @Column(name = "version_lock", length = 10)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn", nullable = false, insertable = true, updatable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "time_adjust", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getTimeAdjust() {
        return timeAdjust;
    }

    public void setTimeAdjust(java.util.Date timeAdjust) {
        this.timeAdjust = timeAdjust;
    }

    @PreUpdate
    public void preUpdate() {

    }

    @PrePersist
    public void prePersist() {
        this.timeAdjust = new java.util.Date();
    }

    @PreRemove
    public void preRemove() {

    }

    @PostPersist
    public void postPersist() {

    }

    @PostLoad
    public void postLoad() {

    }

    @PostRemove
    public void postRemove() {

    }

    @PostUpdate
    public void postUpdate() {

    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount", nullable = false, insertable = true, updatable = false, length = 10, precision = 0)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "remark", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        EmplSalaryAdjustment that = (EmplSalaryAdjustment) o;
//
//        if (id != that.id) return false;
//        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
//        if (timeChange != null ? !timeChange.equals(that.timeChange) : that.timeChange != null) return false;
//        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (amount != null ? amount.hashCode() : 0);
//        result = 31 * result + (timeChange != null ? timeChange.hashCode() : 0);
//        result = 31 * result + (remark != null ? remark.hashCode() : 0);
//        return result;
//    }
}
