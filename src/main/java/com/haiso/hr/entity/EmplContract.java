package com.haiso.hr.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 员工合同记录
 */
@Entity
@Table(name = "t_empl_contract")
public class EmplContract {
    private int id;
    private String contractSn;
    private Date contractDate;
    private Date expiryDate;
    private String location;
    private String remark;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private int version;

    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn", nullable = false, insertable = true, updatable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Version
    @Column(name = "version_lock", length = 10)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.util.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new java.util.Date();
    }

    @PrePersist
    public void prePersist() {
        this.createDate = new java.util.Date();
        this.lastUpdate = new java.util.Date();
        System.out.println("person @PrePersist run!");
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
    @Column(name = "contract_sn", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    public String getContractSn() {
        return contractSn;
    }

    public void setContractSn(String contractSn) {
        this.contractSn = contractSn;
    }

    @Basic
    @Column(name = "contract_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Basic
    @Column(name = "expiry_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Basic
    @Column(name = "location", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "remark", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
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
//        EmplContract that = (EmplContract) o;
//
//        if (id != that.id) return false;
//        if (contractDate != null ? !contractDate.equals(that.contractDate) : that.contractDate != null) return false;
//        if (contractSn != null ? !contractSn.equals(that.contractSn) : that.contractSn != null) return false;
//        if (expiryDate != null ? !expiryDate.equals(that.expiryDate) : that.expiryDate != null) return false;
//        if (location != null ? !location.equals(that.location) : that.location != null) return false;
//        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (contractSn != null ? contractSn.hashCode() : 0);
//        result = 31 * result + (contractDate != null ? contractDate.hashCode() : 0);
//        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
//        result = 31 * result + (location != null ? location.hashCode() : 0);
//        result = 31 * result + (remark != null ? remark.hashCode() : 0);
//        return result;
//    }
}
