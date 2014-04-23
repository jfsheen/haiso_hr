package com.haiso.hr.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ff on 4/15/14.
 * 工资应发记录
 */
@Entity
@Table(name = "t_salary_pay")
public class EmplSalaryPay {
    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String emplSn;

    @Basic
    @javax.persistence.Column(name = "empl_sn", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getEmplSn() {
        return emplSn;
    }

    public void setEmplSn(String emplSn) {
        this.emplSn = emplSn;
    }

    private BigDecimal payRegular;

    @Basic
    @javax.persistence.Column(name = "pay_regular", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPayRegular() {
        return payRegular;
    }

    public void setPayRegular(BigDecimal payRegular) {
        this.payRegular = payRegular;
    }

    private BigDecimal paySeniority;

    @Basic
    @javax.persistence.Column(name = "pay_seniority", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPaySeniority() {
        return paySeniority;
    }

    public void setPaySeniority(BigDecimal paySeniority) {
        this.paySeniority = paySeniority;
    }

    private BigDecimal payPost;

    @Basic
    @javax.persistence.Column(name = "pay_post", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPayPost() {
        return payPost;
    }

    public void setPayPost(BigDecimal payPost) {
        this.payPost = payPost;
    }

    private BigDecimal alloDuty;

    @Basic
    @javax.persistence.Column(name = "allo_duty", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getAlloDuty() {
        return alloDuty;
    }

    public void setAlloDuty(BigDecimal alloDuty) {
        this.alloDuty = alloDuty;
    }

    private BigDecimal feeCoultant;

    @Basic
    @javax.persistence.Column(name = "fee_coultant", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getFeeCoultant() {
        return feeCoultant;
    }

    public void setFeeCoultant(BigDecimal feeCoultant) {
        this.feeCoultant = feeCoultant;
    }

    private BigDecimal payMerit;

    @Basic
    @javax.persistence.Column(name = "pay_merit", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPayMerit() {
        return payMerit;
    }

    public void setPayMerit(BigDecimal payMerit) {
        this.payMerit = payMerit;
    }

    private BigDecimal payAttendance;

    @Basic
    @javax.persistence.Column(name = "pay_attendance", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPayAttendance() {
        return payAttendance;
    }

    public void setPayAttendance(BigDecimal payAttendance) {
        this.payAttendance = payAttendance;
    }

    private BigDecimal payCallback;

    @Basic
    @javax.persistence.Column(name = "pay_callback", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPayCallback() {
        return payCallback;
    }

    public void setPayCallback(BigDecimal payCallback) {
        this.payCallback = payCallback;
    }

    private BigDecimal payWatcher;

    @Basic
    @javax.persistence.Column(name = "pay_watcher", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPayWatcher() {
        return payWatcher;
    }

    public void setPayWatcher(BigDecimal payWatcher) {
        this.payWatcher = payWatcher;
    }

    private BigDecimal alloHealth;

    @Basic
    @javax.persistence.Column(name = "allo_health", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getAlloHealth() {
        return alloHealth;
    }

    public void setAlloHealth(BigDecimal alloHealth) {
        this.alloHealth = alloHealth;
    }

    private BigDecimal alloEducate;

    @Basic
    @javax.persistence.Column(name = "allo_educate", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getAlloEducate() {
        return alloEducate;
    }

    public void setAlloEducate(BigDecimal alloEducate) {
        this.alloEducate = alloEducate;
    }

    private BigDecimal subsidy;

    @Basic
    @javax.persistence.Column(name = "subsidy", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigDecimal subsidy) {
        this.subsidy = subsidy;
    }

    private BigDecimal perquisite;

    @Basic
    @javax.persistence.Column(name = "perquisite", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getPerquisite() {
        return perquisite;
    }

    public void setPerquisite(BigDecimal perquisite) {
        this.perquisite = perquisite;
    }

    private BigDecimal bonus;

    @Basic
    @javax.persistence.Column(name = "bonus", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    private BigDecimal alloChild;

    @Basic
    @javax.persistence.Column(name = "allo_child", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getAlloChild() {
        return alloChild;
    }

    public void setAlloChild(BigDecimal alloChild) {
        this.alloChild = alloChild;
    }

    private BigDecimal alloMeal;

    @Basic
    @javax.persistence.Column(name = "allo_meal", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getAlloMeal() {
        return alloMeal;
    }

    public void setAlloMeal(BigDecimal alloMeal) {
        this.alloMeal = alloMeal;
    }

    private BigDecimal subsRent;

    @Basic
    @javax.persistence.Column(name = "subs_rent", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getSubsRent() {
        return subsRent;
    }

    public void setSubsRent(BigDecimal subsRent) {
        this.subsRent = subsRent;
    }

    private Timestamp lastupdate;

    @Basic
    @javax.persistence.Column(name = "lastupdate", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    public Timestamp getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Timestamp lastupdate) {
        this.lastupdate = lastupdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplSalaryPay that = (EmplSalaryPay) o;

        if (id != that.id) return false;
        if (alloChild != null ? !alloChild.equals(that.alloChild) : that.alloChild != null) return false;
        if (alloDuty != null ? !alloDuty.equals(that.alloDuty) : that.alloDuty != null) return false;
        if (alloEducate != null ? !alloEducate.equals(that.alloEducate) : that.alloEducate != null) return false;
        if (alloHealth != null ? !alloHealth.equals(that.alloHealth) : that.alloHealth != null) return false;
        if (alloMeal != null ? !alloMeal.equals(that.alloMeal) : that.alloMeal != null) return false;
        if (bonus != null ? !bonus.equals(that.bonus) : that.bonus != null) return false;
        if (emplSn != null ? !emplSn.equals(that.emplSn) : that.emplSn != null) return false;
        if (feeCoultant != null ? !feeCoultant.equals(that.feeCoultant) : that.feeCoultant != null) return false;
        if (lastupdate != null ? !lastupdate.equals(that.lastupdate) : that.lastupdate != null) return false;
        if (payAttendance != null ? !payAttendance.equals(that.payAttendance) : that.payAttendance != null)
            return false;
        if (payCallback != null ? !payCallback.equals(that.payCallback) : that.payCallback != null) return false;
        if (payMerit != null ? !payMerit.equals(that.payMerit) : that.payMerit != null) return false;
        if (payPost != null ? !payPost.equals(that.payPost) : that.payPost != null) return false;
        if (payRegular != null ? !payRegular.equals(that.payRegular) : that.payRegular != null) return false;
        if (paySeniority != null ? !paySeniority.equals(that.paySeniority) : that.paySeniority != null) return false;
        if (payWatcher != null ? !payWatcher.equals(that.payWatcher) : that.payWatcher != null) return false;
        if (perquisite != null ? !perquisite.equals(that.perquisite) : that.perquisite != null) return false;
        if (subsRent != null ? !subsRent.equals(that.subsRent) : that.subsRent != null) return false;
        if (subsidy != null ? !subsidy.equals(that.subsidy) : that.subsidy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (emplSn != null ? emplSn.hashCode() : 0);
        result = 31 * result + (payRegular != null ? payRegular.hashCode() : 0);
        result = 31 * result + (paySeniority != null ? paySeniority.hashCode() : 0);
        result = 31 * result + (payPost != null ? payPost.hashCode() : 0);
        result = 31 * result + (alloDuty != null ? alloDuty.hashCode() : 0);
        result = 31 * result + (feeCoultant != null ? feeCoultant.hashCode() : 0);
        result = 31 * result + (payMerit != null ? payMerit.hashCode() : 0);
        result = 31 * result + (payAttendance != null ? payAttendance.hashCode() : 0);
        result = 31 * result + (payCallback != null ? payCallback.hashCode() : 0);
        result = 31 * result + (payWatcher != null ? payWatcher.hashCode() : 0);
        result = 31 * result + (alloHealth != null ? alloHealth.hashCode() : 0);
        result = 31 * result + (alloEducate != null ? alloEducate.hashCode() : 0);
        result = 31 * result + (subsidy != null ? subsidy.hashCode() : 0);
        result = 31 * result + (perquisite != null ? perquisite.hashCode() : 0);
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + (alloChild != null ? alloChild.hashCode() : 0);
        result = 31 * result + (alloMeal != null ? alloMeal.hashCode() : 0);
        result = 31 * result + (subsRent != null ? subsRent.hashCode() : 0);
        result = 31 * result + (lastupdate != null ? lastupdate.hashCode() : 0);
        return result;
    }
}
