package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ff on 4/15/14.
 * 员工工资情况
 */
@Entity
@Table(name = "t_empl_salary_info")
public class EmplInfo {
    private Integer id;
    private Boolean isPost;
    private Boolean byTime;
    private Boolean byPiece;
    private BigDecimal ratioEval;
    private BigDecimal ratioPrepay;
    private String lsnInsuPesn;//location SN insurance pension
    private String lsnInsuMed; //location SN insurance medical
    private String lsnInsuLqMed;//location SN large quality medical
    private String lsnInsuHouse;//location SN fund of housing
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
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public Boolean isPost() {
        return isPost;
    }

    public void setPost(Boolean isPost) {
        this.isPost = isPost;
    }

    @Basic
    @Column(name = "by_time", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public Boolean isByTime() {
        return byTime;
    }

    public void setByTime(Boolean byTime) {
        this.byTime = byTime;
    }

    @Basic
    @Column(name = "by_piece", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public Boolean isByPiece() {
        return byPiece;
    }

    public void setByPiece(Boolean byPiece) {
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
    public int hashCode() {
        return Objects.hashCode(id, isPost, byTime, byPiece, ratioEval, ratioPrepay, lsnInsuPesn, lsnInsuMed, lsnInsuLqMed, lsnInsuHouse, lastUpdate, createDate, version, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final EmplInfo other = (EmplInfo) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.isPost, other.isPost) && Objects.equal(this.byTime, other.byTime) && Objects.equal(this.byPiece, other.byPiece) && Objects.equal(this.ratioEval, other.ratioEval) && Objects.equal(this.ratioPrepay, other.ratioPrepay) && Objects.equal(this.lsnInsuPesn, other.lsnInsuPesn) && Objects.equal(this.lsnInsuMed, other.lsnInsuMed) && Objects.equal(this.lsnInsuLqMed, other.lsnInsuLqMed) && Objects.equal(this.lsnInsuHouse, other.lsnInsuHouse) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version) && Objects.equal(this.employee, other.employee);
    }
}
