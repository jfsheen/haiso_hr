package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 * 员工工资调整记录
 */
@Entity
@Table(name = "t_empl_salary_adjust")
public class Adjustment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "amount")
    private Integer amount; //单位为:li
    @Basic
    @Column(name = "remark")
    private String remark; //备注，必填
    @Basic
    @Column(name = "time_adjust")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeAdjust;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdate;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createDate;
    @Version
    @Column(name = "version_lock", length = 10)
    private Integer version;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn")
    private Employee employee;


    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, amount, remark, timeAdjust, lastUpdate, createDate, version, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Adjustment other = (Adjustment) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.amount, other.amount) && Objects.equal(this.remark, other.remark) && Objects.equal(this.timeAdjust, other.timeAdjust) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version) && Objects.equal(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("amount", amount)
                .add("remark", remark)
                .add("timeAdjust", timeAdjust)
                .add("lastUpdate", lastUpdate)
                .add("createDate", createDate)
                .add("version", version)
                .add("employee", employee)
                .toString();
    }
}
