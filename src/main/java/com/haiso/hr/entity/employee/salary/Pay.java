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
    private Long payRegular;

    @Basic
    @Column(name = "pay_callback")
    private Long payCallback;

    @Basic
    @Column(name = "pay_seniority")
    private Long paySeniority;


    @Basic
    @Column(name = "pay_post")
    private Long payPost;

    @Basic
    @Column(name = "allo_duty")
    private Long alloDuty;

    @Basic
    @Column(name = "fee_coultant")
    private Long feeCoultant;

    @Basic
    @Column(name = "pay_merit")
    private Long payMerit;

    @Basic
    @Column(name = "pay_attendance")
    private Long payAttendance;

    @Basic
    @Column(name = "pay_watcher")
    private Long payWatcher;

    @Basic
    @Column(name = "allo_health")
    private Long alloHealth;

    @Basic
    @Column(name = "allo_educate")
    private Long alloEducate;

    @Basic
    @Column(name = "subsidy")
    private Long subsidy;

    @Basic
    @Column(name = "perquisite")
    private Long perquisite;

    @Basic
    @Column(name = "bonus")
    private Long bonus;

    @Basic
    @Column(name = "allo_child")
    private Long alloChild;

    @Basic
    @Column(name = "allo_meal")
    private Long alloMeal;

    @Basic
    @Column(name = "subs_rent")
    private Long subsRent;

    public Long getPayRegular() {
        return payRegular;
    }

    public void setPayRegular(Long payRegular) {
        this.payRegular = payRegular;
    }

    public Long getPaySeniority() {
        return paySeniority;
    }

    public void setPaySeniority(Long paySeniority) {
        this.paySeniority = paySeniority;
    }

    public Long getPayPost() {
        return payPost;
    }

    public void setPayPost(Long payPost) {
        this.payPost = payPost;
    }

    public Long getAlloDuty() {
        return alloDuty;
    }

    public void setAlloDuty(Long alloDuty) {
        this.alloDuty = alloDuty;
    }

    public Long getFeeCoultant() {
        return feeCoultant;
    }

    public void setFeeCoultant(Long feeCoultant) {
        this.feeCoultant = feeCoultant;
    }

    public Long getPayMerit() {
        return payMerit;
    }

    public void setPayMerit(Long payMerit) {
        this.payMerit = payMerit;
    }

    public Long getPayAttendance() {
        return payAttendance;
    }

    public void setPayAttendance(Long payAttendance) {
        this.payAttendance = payAttendance;
    }

    public Long getPayCallback() {
        return payCallback;
    }

    public void setPayCallback(Long payCallback) {
        this.payCallback = payCallback;
    }

    public Long getPayWatcher() {
        return payWatcher;
    }

    public void setPayWatcher(Long payWatcher) {
        this.payWatcher = payWatcher;
    }

    public Long getAlloHealth() {
        return alloHealth;
    }

    public void setAlloHealth(Long alloHealth) {
        this.alloHealth = alloHealth;
    }


    public Long getAlloEducate() {
        return alloEducate;
    }

    public void setAlloEducate(Long alloEducate) {
        this.alloEducate = alloEducate;
    }

    public Long getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Long subsidy) {
        this.subsidy = subsidy;
    }

    public Long getPerquisite() {
        return perquisite;
    }

    public void setPerquisite(Long perquisite) {
        this.perquisite = perquisite;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Long getAlloChild() {
        return alloChild;
    }

    public void setAlloChild(Long alloChild) {
        this.alloChild = alloChild;
    }


    public Long getAlloMeal() {
        return alloMeal;
    }

    public void setAlloMeal(Long alloMeal) {
        this.alloMeal = alloMeal;
    }

    public Long getSubsRent() {
        return subsRent;
    }

    public void setSubsRent(Long subsRent) {
        this.subsRent = subsRent;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(payRegular, payCallback, paySeniority, payPost, alloDuty, feeCoultant, payMerit, payAttendance, payWatcher, alloHealth, alloEducate, subsidy, perquisite, bonus, alloChild, alloMeal, subsRent);
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
        return Objects.equal(this.payRegular, other.payRegular) && Objects.equal(this.payCallback, other.payCallback) && Objects.equal(this.paySeniority, other.paySeniority) && Objects.equal(this.payPost, other.payPost) && Objects.equal(this.alloDuty, other.alloDuty) && Objects.equal(this.feeCoultant, other.feeCoultant) && Objects.equal(this.payMerit, other.payMerit) && Objects.equal(this.payAttendance, other.payAttendance) && Objects.equal(this.payWatcher, other.payWatcher) && Objects.equal(this.alloHealth, other.alloHealth) && Objects.equal(this.alloEducate, other.alloEducate) && Objects.equal(this.subsidy, other.subsidy) && Objects.equal(this.perquisite, other.perquisite) && Objects.equal(this.bonus, other.bonus) && Objects.equal(this.alloChild, other.alloChild) && Objects.equal(this.alloMeal, other.alloMeal) && Objects.equal(this.subsRent, other.subsRent);
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
