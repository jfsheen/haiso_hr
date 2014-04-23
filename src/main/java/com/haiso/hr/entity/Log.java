package com.haiso.hr.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ff on 4/15/14.
 */
@Entity
@Table(name = "t_log")
public class Log {
    private int id;
    private String action;
    private String tableName;
    private int rowId;
    private int rowsAffected;
    private String manager;
    private Timestamp time;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "rows_affected", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(int rowsAffected) {
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

    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (id != log.id) return false;
        if (rowId != log.rowId) return false;
        if (rowsAffected != log.rowsAffected) return false;
        if (action != null ? !action.equals(log.action) : log.action != null) return false;
        if (manager != null ? !manager.equals(log.manager) : log.manager != null) return false;
        if (tableName != null ? !tableName.equals(log.tableName) : log.tableName != null) return false;
        if (time != null ? !time.equals(log.time) : log.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + rowId;
        result = 31 * result + rowsAffected;
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
