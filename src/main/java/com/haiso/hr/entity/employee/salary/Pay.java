package com.haiso.hr.entity.employee.salary;

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Pay that = (Pay) o;
//
//        if (id != that.id) return false;
//        if (alloChild != null ? !alloChild.equals(that.alloChild) : that.alloChild != null) return false;
//        if (alloDuty != null ? !alloDuty.equals(that.alloDuty) : that.alloDuty != null) return false;
//        if (alloEducate != null ? !alloEducate.equals(that.alloEducate) : that.alloEducate != null) return false;
//        if (alloHealth != null ? !alloHealth.equals(that.alloHealth) : that.alloHealth != null) return false;
//        if (alloMeal != null ? !alloMeal.equals(that.alloMeal) : that.alloMeal != null) return false;
//        if (bonus != null ? !bonus.equals(that.bonus) : that.bonus != null) return false;
//        if (emplSn != null ? !emplSn.equals(that.emplSn) : that.emplSn != null) return false;
//        if (feeCoultant != null ? !feeCoultant.equals(that.feeCoultant) : that.feeCoultant != null) return false;
//        if (lastupdate != null ? !lastupdate.equals(that.lastupdate) : that.lastupdate != null) return false;
//        if (payAttendance != null ? !payAttendance.equals(that.payAttendance) : that.payAttendance != null)
//            return false;
//        if (payCallback != null ? !payCallback.equals(that.payCallback) : that.payCallback != null) return false;
//        if (payMerit != null ? !payMerit.equals(that.payMerit) : that.payMerit != null) return false;
//        if (payPost != null ? !payPost.equals(that.payPost) : that.payPost != null) return false;
//        if (payRegular != null ? !payRegular.equals(that.payRegular) : that.payRegular != null) return false;
//        if (paySeniority != null ? !paySeniority.equals(that.paySeniority) : that.paySeniority != null) return false;
//        if (payWatcher != null ? !payWatcher.equals(that.payWatcher) : that.payWatcher != null) return false;
//        if (perquisite != null ? !perquisite.equals(that.perquisite) : that.perquisite != null) return false;
//        if (subsRent != null ? !subsRent.equals(that.subsRent) : that.subsRent != null) return false;
//        if (subsidy != null ? !subsidy.equals(that.subsidy) : that.subsidy != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (emplSn != null ? emplSn.hashCode() : 0);
//        result = 31 * result + (payRegular != null ? payRegular.hashCode() : 0);
//        result = 31 * result + (paySeniority != null ? paySeniority.hashCode() : 0);
//        result = 31 * result + (payPost != null ? payPost.hashCode() : 0);
//        result = 31 * result + (alloDuty != null ? alloDuty.hashCode() : 0);
//        result = 31 * result + (feeCoultant != null ? feeCoultant.hashCode() : 0);
//        result = 31 * result + (payMerit != null ? payMerit.hashCode() : 0);
//        result = 31 * result + (payAttendance != null ? payAttendance.hashCode() : 0);
//        result = 31 * result + (payCallback != null ? payCallback.hashCode() : 0);
//        result = 31 * result + (payWatcher != null ? payWatcher.hashCode() : 0);
//        result = 31 * result + (alloHealth != null ? alloHealth.hashCode() : 0);
//        result = 31 * result + (alloEducate != null ? alloEducate.hashCode() : 0);
//        result = 31 * result + (subsidy != null ? subsidy.hashCode() : 0);
//        result = 31 * result + (perquisite != null ? perquisite.hashCode() : 0);
//        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
//        result = 31 * result + (alloChild != null ? alloChild.hashCode() : 0);
//        result = 31 * result + (alloMeal != null ? alloMeal.hashCode() : 0);
//        result = 31 * result + (subsRent != null ? subsRent.hashCode() : 0);
//        result = 31 * result + (lastupdate != null ? lastupdate.hashCode() : 0);
//        return result;
//    }
}
