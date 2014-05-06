package com.haiso.hr.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 */
@Entity
@Table(name = "t_log")
public class Log {
    private Integer id;
    private String action;
    private String tableName;
    private Integer rowId;
    private Integer rowsAffected;
    private String manager;
    private Date lastUpdate;
    private Date createDate;
    private Integer version;

    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

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
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new Date();
    }

    @PrePersist
    public void prePersist() {
        this.createDate = new Date();
        this.lastUpdate = new Date();
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "action", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "table_name", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "row_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }


    @Basic
    @Column(name = "rows_affected", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(Integer rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    @Basic
    @Column(name = "manager", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, action, tableName, rowId, rowsAffected, manager, lastUpdate, createDate, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Log other = (Log) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.action, other.action) && Objects.equal(this.tableName, other.tableName) && Objects.equal(this.rowId, other.rowId) && Objects.equal(this.rowsAffected, other.rowsAffected) && Objects.equal(this.manager, other.manager) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version);
    }
}
