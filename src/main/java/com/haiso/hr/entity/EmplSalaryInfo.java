package com.haiso.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ff on 4/15/14.
 * 员工工资情况
 */
@Entity
@Table(name = "t_empl_salary_info")
public class EmplSalaryInfo {
    private int id;
    private boolean isPost;
    private boolean byTime;
    private boolean byPiece;
    private BigDecimal ratioEval;
    private BigDecimal ratioPrepay;
    private String lsnInsuPesn;//location SN insurance pension
    private String lsnInsuMed; //location SN insurance medical
    private String lsnInsuLqMed;//location SN large quality medical
    private String lsnInsuHouse;//location SN fund of housing
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private int version;

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
    @Column(name = "is_post", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public boolean isPost() {
        return isPost;
    }

    public void setPost(boolean isPost) {
        this.isPost = isPost;
    }

    @Basic
    @Column(name = "by_time", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public boolean isByTime() {
        return byTime;
    }

    public void setByTime(boolean byTime) {
        this.byTime = byTime;
    }

    @Basic
    @Column(name = "by_piece", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public boolean isByPiece() {
        return byPiece;
    }

    public void setByPiece(boolean byPiece) {
        this.byPiece = byPiece;
    }

    @Basic
    @Column(name = "ratio_eval", nullable = false, insertable = true, updatable = true, length = 4, precision = 3)
    public BigDecimal getRatioEval() {
        return ratioEval;
    }

    public void setRatioEval(BigDecimal ratioEval) {
        this.ratioEval = ratioEval;
    }

    @Basic
    @Column(name = "ratio_prepay", nullable = false, insertable = true, updatable = true, length = 4, precision = 3)
    public BigDecimal getRatioPrepay() {
        return ratioPrepay;
    }

    public void setRatioPrepay(BigDecimal ratioPrepay) {
        this.ratioPrepay = ratioPrepay;
    }

    @Basic
    @Column(name = "lsn_insupesn", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getLsnInsupesn() {
        return lsnInsuPesn;
    }

    public void setLsnInsupesn(String lsnInsuPesn) {
        this.lsnInsuPesn = lsnInsuPesn;
    }

    @Basic
    @Column(name = "lsn_insumed", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getLsnInsumed() {
        return lsnInsuMed;
    }

    public void setLsnInsumed(String lsnInsuMed) {
        this.lsnInsuMed = lsnInsuMed;
    }

    @Basic
    @Column(name = "lsn_insulqmed", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getLsnInsulqmed() {
        return lsnInsuLqMed;
    }

    public void setLsnInsulqmed(String lsnInsuLqMed) {
        this.lsnInsuLqMed = lsnInsuLqMed;
    }

    @Basic
    @Column(name = "lsn_fundhouse", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getLsnFundhouse() {
        return lsnInsuHouse;
    }

    public void setLsnFundhouse(String lsnInsuHouse) {
        this.lsnInsuHouse = lsnInsuHouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplSalaryInfo that = (EmplSalaryInfo) o;

        if (byPiece != that.byPiece) return false;
        if (byTime != that.byTime) return false;
        if (id != that.id) return false;
        if (isPost != that.isPost) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (lsnInsuHouse != null ? !lsnInsuHouse.equals(that.lsnInsuHouse) : that.lsnInsuHouse != null) return false;
        if (lsnInsuLqMed != null ? !lsnInsuLqMed.equals(that.lsnInsuLqMed) : that.lsnInsuLqMed != null) return false;
        if (lsnInsuMed != null ? !lsnInsuMed.equals(that.lsnInsuMed) : that.lsnInsuMed != null) return false;
        if (lsnInsuPesn != null ? !lsnInsuPesn.equals(that.lsnInsuPesn) : that.lsnInsuPesn != null) return false;
        if (ratioEval != null ? !ratioEval.equals(that.ratioEval) : that.ratioEval != null) return false;
        if (ratioPrepay != null ? !ratioPrepay.equals(that.ratioPrepay) : that.ratioPrepay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (isPost ? 1 : 0);
        result = 31 * result + (byTime ? 1 : 0);
        result = 31 * result + (byPiece ? 1 : 0);
        result = 31 * result + (ratioEval != null ? ratioEval.hashCode() : 0);
        result = 31 * result + (ratioPrepay != null ? ratioPrepay.hashCode() : 0);
        result = 31 * result + (lsnInsuPesn != null ? lsnInsuPesn.hashCode() : 0);
        result = 31 * result + (lsnInsuMed != null ? lsnInsuMed.hashCode() : 0);
        result = 31 * result + (lsnInsuLqMed != null ? lsnInsuLqMed.hashCode() : 0);
        result = 31 * result + (lsnInsuHouse != null ? lsnInsuHouse.hashCode() : 0);
        return result;
    }
}
