package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by ff on 4/15/14.
 * 工资应发记录
 */
@Embeddable
public class Pay {


    private int payRegular;

    @Column(name = "pay_regular", nullable = false, length = 10, precision = 0)
    public int getPayRegular() {
        return payRegular;
    }

    public void setPayRegular(int payRegular) {
        this.payRegular = payRegular;
    }

    private int paySeniority;


    @Column(name = "pay_seniority", nullable = false, length = 10, precision = 0)
    public int getPaySeniority() {
        return paySeniority;
    }

    public void setPaySeniority(int paySeniority) {
        this.paySeniority = paySeniority;
    }

    private int payPost;


    @Column(name = "pay_post", nullable = false, length = 10, precision = 0)
    public int getPayPost() {
        return payPost;
    }

    public void setPayPost(int payPost) {
        this.payPost = payPost;
    }

    private int alloDuty;


    @Column(name = "allo_duty", nullable = false, length = 10, precision = 0)
    public int getAlloDuty() {
        return alloDuty;
    }

    public void setAlloDuty(int alloDuty) {
        this.alloDuty = alloDuty;
    }

    private int feeCoultant;


    @Column(name = "fee_coultant", nullable = false, length = 10, precision = 0)
    public int getFeeCoultant() {
        return feeCoultant;
    }

    public void setFeeCoultant(int feeCoultant) {
        this.feeCoultant = feeCoultant;
    }

    private int payMerit;


    @Column(name = "pay_merit", nullable = false, length = 10, precision = 0)
    public int getPayMerit() {
        return payMerit;
    }

    public void setPayMerit(int payMerit) {
        this.payMerit = payMerit;
    }

    private int payAttendance;


    @Column(name = "pay_attendance", nullable = false, length = 10, precision = 0)
    public int getPayAttendance() {
        return payAttendance;
    }

    public void setPayAttendance(int payAttendance) {
        this.payAttendance = payAttendance;
    }

    private int payCallback;


    @Column(name = "pay_callback", nullable = false, length = 10, precision = 0)
    public int getPayCallback() {
        return payCallback;
    }

    public void setPayCallback(int payCallback) {
        this.payCallback = payCallback;
    }

    private int payWatcher;


    @Column(name = "pay_watcher", nullable = false, length = 10, precision = 0)
    public int getPayWatcher() {
        return payWatcher;
    }

    public void setPayWatcher(int payWatcher) {
        this.payWatcher = payWatcher;
    }

    private int alloHealth;


    @Column(name = "allo_health", nullable = false, length = 10, precision = 0)
    public int getAlloHealth() {
        return alloHealth;
    }

    public void setAlloHealth(int alloHealth) {
        this.alloHealth = alloHealth;
    }

    private int alloEducate;


    @Column(name = "allo_educate", nullable = false, length = 10, precision = 0)
    public int getAlloEducate() {
        return alloEducate;
    }

    public void setAlloEducate(int alloEducate) {
        this.alloEducate = alloEducate;
    }

    private int subsidy;


    @Column(name = "subsidy", nullable = false, length = 10, precision = 0)
    public int getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(int subsidy) {
        this.subsidy = subsidy;
    }

    private int perquisite;


    @Column(name = "perquisite", nullable = false, length = 10, precision = 0)
    public int getPerquisite() {
        return perquisite;
    }

    public void setPerquisite(int perquisite) {
        this.perquisite = perquisite;
    }

    private int bonus;


    @Column(name = "bonus", nullable = false, length = 10, precision = 0)
    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    private int alloChild;


    @Column(name = "allo_child", nullable = false, length = 10, precision = 0)
    public int getAlloChild() {
        return alloChild;
    }

    public void setAlloChild(int alloChild) {
        this.alloChild = alloChild;
    }

    private int alloMeal;


    @Column(name = "allo_meal", nullable = false, length = 10, precision = 0)
    public int getAlloMeal() {
        return alloMeal;
    }

    public void setAlloMeal(int alloMeal) {
        this.alloMeal = alloMeal;
    }

    private int subsRent;


    @Column(name = "subs_rent", nullable = false, length = 10, precision = 0)
    public int getSubsRent() {
        return subsRent;
    }

    public void setSubsRent(int subsRent) {
        this.subsRent = subsRent;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("payRegular", payRegular)
                .add("paySeniority", paySeniority)
                .add("payPost", payPost)
                .add("alloDuty", alloDuty)
                .add("feeCoultant", feeCoultant)
                .add("payMerit", payMerit)
                .add("payAttendance", payAttendance)
                .add("payCallback", payCallback)
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
}
