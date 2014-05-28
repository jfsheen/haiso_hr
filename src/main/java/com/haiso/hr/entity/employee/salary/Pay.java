package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by ff on 4/15/14.
 * 工资应发记录
 */
@Embeddable
public class Pay {

    @Basic
    @Column(name = "pay_regular")
    private Integer payRegular;

    @Basic
    @Column(name = "pay_callback")
    private Integer payCallback;

    @Basic
    @Column(name = "pay_seniority")
    private Integer paySeniority;


    @Basic
    @Column(name = "pay_post")
    private Integer payPost;

    @Basic
    @Column(name = "allo_duty")
    private Integer alloDuty;

    @Basic
    @Column(name = "fee_coultant")
    private Integer feeCoultant;

    @Basic
    @Column(name = "pay_merit")
    private Integer payMerit;

    @Basic
    @Column(name = "pay_attendance")
    private Integer payAttendance;

    @Basic
    @Column(name = "pay_watcher")
    private Integer payWatcher;

    @Basic
    @Column(name = "allo_health")
    private Integer alloHealth;

    @Basic
    @Column(name = "allo_educate")
    private Integer alloEducate;

    @Basic
    @Column(name = "subsidy")
    private Integer subsidy;

    @Basic
    @Column(name = "perquisite")
    private Integer perquisite;

    @Basic
    @Column(name = "bonus")
    private Integer bonus;

    @Basic
    @Column(name = "allo_child")
    private Integer alloChild;

    @Basic
    @Column(name = "allo_meal")
    private Integer alloMeal;

    @Basic
    @Column(name = "subs_rent")
    private Integer subsRent;

    public Integer getPayRegular() {
        return payRegular;
    }

    public void setPayRegular(Integer payRegular) {
        this.payRegular = payRegular;
    }

    public Integer getPaySeniority() {
        return paySeniority;
    }

    public void setPaySeniority(Integer paySeniority) {
        this.paySeniority = paySeniority;
    }

    public Integer getPayPost() {
        return payPost;
    }

    public void setPayPost(Integer payPost) {
        this.payPost = payPost;
    }

    public Integer getAlloDuty() {
        return alloDuty;
    }

    public void setAlloDuty(Integer alloDuty) {
        this.alloDuty = alloDuty;
    }

    public Integer getFeeCoultant() {
        return feeCoultant;
    }

    public void setFeeCoultant(Integer feeCoultant) {
        this.feeCoultant = feeCoultant;
    }

    public Integer getPayMerit() {
        return payMerit;
    }

    public void setPayMerit(Integer payMerit) {
        this.payMerit = payMerit;
    }

    public Integer getPayAttendance() {
        return payAttendance;
    }

    public void setPayAttendance(Integer payAttendance) {
        this.payAttendance = payAttendance;
    }

    public Integer getPayCallback() {
        return payCallback;
    }

    public void setPayCallback(Integer payCallback) {
        this.payCallback = payCallback;
    }

    public Integer getPayWatcher() {
        return payWatcher;
    }

    public void setPayWatcher(Integer payWatcher) {
        this.payWatcher = payWatcher;
    }

    public Integer getAlloHealth() {
        return alloHealth;
    }

    public void setAlloHealth(Integer alloHealth) {
        this.alloHealth = alloHealth;
    }


    public Integer getAlloEducate() {
        return alloEducate;
    }

    public void setAlloEducate(Integer alloEducate) {
        this.alloEducate = alloEducate;
    }

    public Integer getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Integer subsidy) {
        this.subsidy = subsidy;
    }

    public Integer getPerquisite() {
        return perquisite;
    }

    public void setPerquisite(Integer perquisite) {
        this.perquisite = perquisite;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getAlloChild() {
        return alloChild;
    }

    public void setAlloChild(Integer alloChild) {
        this.alloChild = alloChild;
    }


    public Integer getAlloMeal() {
        return alloMeal;
    }

    public void setAlloMeal(Integer alloMeal) {
        this.alloMeal = alloMeal;
    }

    public Integer getSubsRent() {
        return subsRent;
    }

    public void setSubsRent(Integer subsRent) {
        this.subsRent = subsRent;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(payRegular, paySeniority, payPost, alloDuty, feeCoultant, payMerit, payAttendance, payCallback, payWatcher, alloHealth, alloEducate, subsidy, perquisite, bonus, alloChild, alloMeal, subsRent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Pay other = (Pay) obj;
        return Objects.equal(this.payRegular, other.payRegular) && Objects.equal(this.paySeniority, other.paySeniority) && Objects.equal(this.payPost, other.payPost) && Objects.equal(this.alloDuty, other.alloDuty) && Objects.equal(this.feeCoultant, other.feeCoultant) && Objects.equal(this.payMerit, other.payMerit) && Objects.equal(this.payAttendance, other.payAttendance) && Objects.equal(this.payCallback, other.payCallback) && Objects.equal(this.payWatcher, other.payWatcher) && Objects.equal(this.alloHealth, other.alloHealth) && Objects.equal(this.alloEducate, other.alloEducate) && Objects.equal(this.subsidy, other.subsidy) && Objects.equal(this.perquisite, other.perquisite) && Objects.equal(this.bonus, other.bonus) && Objects.equal(this.alloChild, other.alloChild) && Objects.equal(this.alloMeal, other.alloMeal) && Objects.equal(this.subsRent, other.subsRent);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("payRegular", payRegular)
                .add("payCallback", payCallback)
                .add("paySeniority", paySeniority)
                .add("payPost", payPost)
                .add("alloDuty", alloDuty)
                .add("feeCoultant", feeCoultant)
                .add("payMerit", payMerit)
                .add("payAttendance", payAttendance)
                .add("payWatcher", payWatcher)
                .add("alloHealth", alloHealth)
                .add("alloEducate", alloEducate)
                .add("subsidy", subsidy)
                .add("perquisite", perquisite)
                .add("bonus", bonus)
                .add("alloChild", alloChild)
                .add("alloMeal", alloMeal)
                .add("subsRent", subsRent)
                .toString();
    }
}
