package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;
import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 员工工资情况
 */
@Entity
@Table(name = "t_empl_salary_info")
public class SalaryInfo extends AuditBaseEntity{

    @Basic
    @Column(name = "is_post")
    private Boolean isPost;
    @Basic
    @Column(name = "by_time")
    private Boolean byTime;
    @Basic
    @Column(name = "by_piece")
    private Boolean byPiece;
    @Basic
    @Column(name = "ratio_eval")
    private Short ratioEval;
    @Basic
    @Column(name = "ratio_prepay")
    private Short ratioPrepay;
    @Basic
    @Column(name = "lsn_insupesn")
    private Short lsnInsuPesn;//location SN insurance pension
    @Basic
    @Column(name = "lsn_insumed")
    private Short lsnInsuMed; //location SN insurance medical
    @Basic
    @Column(name = "lsn_insulqmed")
    private Short lsnInsuLqMed;//location SN large quality medical
    @Basic
    @Column(name = "lsn_fundhouse")
    private Short lsnInsuHouse;//location SN fund of housing
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn", nullable = false)
    private Employee employee;


    public Boolean getIsPost() {
        return isPost;
    }

    public void setIsPost(Boolean isPost) {
        this.isPost = isPost;
    }

    public Boolean getByTime() {
        return byTime;
    }

    public void setByTime(Boolean byTime) {
        this.byTime = byTime;
    }

    public Boolean getByPiece() {
        return byPiece;
    }

    public void setByPiece(Boolean byPiece) {
        this.byPiece = byPiece;
    }

    public Short getRatioEval() {
        return ratioEval;
    }

    public void setRatioEval(Short ratioEval) {
        this.ratioEval = ratioEval;
    }

    public Short getRatioPrepay() {
        return ratioPrepay;
    }

    public void setRatioPrepay(Short ratioPrepay) {
        this.ratioPrepay = ratioPrepay;
    }

    public Short getLsnInsuPesn() {
        return lsnInsuPesn;
    }

    public void setLsnInsuPesn(Short lsnInsuPesn) {
        this.lsnInsuPesn = lsnInsuPesn;
    }

    public Short getLsnInsuMed() {
        return lsnInsuMed;
    }

    public void setLsnInsuMed(Short lsnInsuMed) {
        this.lsnInsuMed = lsnInsuMed;
    }

    public Short getLsnInsuLqMed() {
        return lsnInsuLqMed;
    }

    public void setLsnInsuLqMed(Short lsnInsuLqMed) {
        this.lsnInsuLqMed = lsnInsuLqMed;
    }

    public Short getLsnInsuHouse() {
        return lsnInsuHouse;
    }

    public void setLsnInsuHouse(Short lsnInsuHouse) {
        this.lsnInsuHouse = lsnInsuHouse;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(isPost, byTime, byPiece, ratioEval, ratioPrepay, lsnInsuPesn, lsnInsuMed, lsnInsuLqMed, lsnInsuHouse, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final SalaryInfo other = (SalaryInfo) obj;
        return Objects.equal(this.isPost, other.isPost) && Objects.equal(this.byTime, other.byTime) && Objects.equal(this.byPiece, other.byPiece) && Objects.equal(this.ratioEval, other.ratioEval) && Objects.equal(this.ratioPrepay, other.ratioPrepay) && Objects.equal(this.lsnInsuPesn, other.lsnInsuPesn) && Objects.equal(this.lsnInsuMed, other.lsnInsuMed) && Objects.equal(this.lsnInsuLqMed, other.lsnInsuLqMed) && Objects.equal(this.lsnInsuHouse, other.lsnInsuHouse) && Objects.equal(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("isPost", isPost)
                .add("byTime", byTime)
                .add("byPiece", byPiece)
                .add("ratioEval", ratioEval)
                .add("ratioPrepay", ratioPrepay)
                .add("lsnInsuPesn", lsnInsuPesn)
                .add("lsnInsuMed", lsnInsuMed)
                .add("lsnInsuLqMed", lsnInsuLqMed)
                .add("lsnInsuHouse", lsnInsuHouse)
                .add("employee", employee)
                .toString();
    }
}
