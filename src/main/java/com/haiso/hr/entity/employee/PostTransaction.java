package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 */
@Entity
@Table(name = "t_empl_pos_tx")
public class PostTransaction {
    private Integer id;
    private Employee employee;
    private String status;
    private String remark;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private Integer version;


    @Version
    @Column(name = "version_lock", length = 10)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empl_sn", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "remark", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, employee, status, remark, lastUpdate, createDate, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final PostTransaction other = (PostTransaction) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.employee, other.employee) && Objects.equal(this.status, other.status) && Objects.equal(this.remark, other.remark) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version);
    }
}
