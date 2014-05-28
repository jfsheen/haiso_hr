package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 5/28/14.
 */
@Entity
@Table(name = "t_salary_add")
public class Additional {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "is_buckle")
    private Boolean isBuckle;
    @Basic
    @Column(name = "amount")
    private Integer amount;
    @Basic
    @Column(name = "remark")
    private String remark;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salary_id")
    private Salary salary;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdate;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createDate;
    @Version
    @Column(name = "version_lock")
    private Integer version;
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("isBuckle", isBuckle)
                .add("amount", amount)
                .add("remark", remark)
                .add("salary", salary)
                .add("lastUpdate", lastUpdate)
                .add("createDate", createDate)
                .add("version", version)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, isBuckle, amount, remark, salary, lastUpdate, createDate, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Additional other = (Additional) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.isBuckle, other.isBuckle) && Objects.equal(this.amount, other.amount) && Objects.equal(this.remark, other.remark) && Objects.equal(this.salary, other.salary) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version);
    }

    public Long getId() {
    
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsBuckle() {
        return isBuckle;
    }

    public void setIsBuckle(Boolean isBuckle) {
        this.isBuckle = isBuckle;
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

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

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
    
    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new java.util.Date();
    }

    @PrePersist
    public void prePersist() {
        this.createDate = new java.util.Date();
        this.lastUpdate = new java.util.Date();
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


}
