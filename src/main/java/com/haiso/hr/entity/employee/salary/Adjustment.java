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

    private Integer id;
    private Integer amount; //单位为:分
    private String remark; //备注，必填
    private Date timeAdjust;
    private Integer version;

    @Version
    @Column(name = "version_lock", length = 10)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
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
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount", nullable = false, insertable = true, updatable = false, length = 10, precision = 0)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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

    @Override
    public int hashCode() {
        return Objects.hashCode(id, amount, remark, timeAdjust, version, employee);
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
        return Objects.equal(this.id, other.id) && Objects.equal(this.amount, other.amount) && Objects.equal(this.remark, other.remark) && Objects.equal(this.timeAdjust, other.timeAdjust) && Objects.equal(this.version, other.version) && Objects.equal(this.employee, other.employee);
    }
}
