package com.haiso.hr.entity.employee.salary;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by ff on 4/15/14.
 * 工资应扣记录
 */
@Embeddable
public class Deduct {

    private int insuPension;
    private int insuMedical;
    private int insuUnempl;
    private int insuLqmed;
    private int fundHouse;
    private int feeWater;
    private int feeElectric;
    private int feeGas;
    private int feeProperty;
    private int duesUnion;
    private int taxIncome;
    private int taxStamp;
    private int costRent;


    @Column(name = "insu_pension", nullable = false, length = 10, precision = 0)
    public int getInsuPension() {
        return insuPension;
    }

    public void setInsuPension(int insuPension) {
        this.insuPension = insuPension;
    }


    @Column(name = "insu_medical", nullable = false, length = 10, precision = 0)
    public int getInsuMedical() {
        return insuMedical;
    }

    public void setInsuMedical(int insuMedical) {
        this.insuMedical = insuMedical;
    }


    @Column(name = "insu_unempl", nullable = false, length = 10, precision = 0)
    public int getInsuUnempl() {
        return insuUnempl;
    }

    public void setInsuUnempl(int insuUnempl) {
        this.insuUnempl = insuUnempl;
    }


    @Column(name = "insu_lqmed", nullable = false, length = 10, precision = 0)
    public int getInsuLqmed() {
        return insuLqmed;
    }

    public void setInsuLqmed(int insuLqmed) {
        this.insuLqmed = insuLqmed;
    }


    @Column(name = "fund_house", nullable = false, length = 10, precision = 0)
    public int getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(int fundHouse) {
        this.fundHouse = fundHouse;
    }


    @Column(name = "fee_water", nullable = false, length = 10, precision = 0)
    public int getFeeWater() {
        return feeWater;
    }

    public void setFeeWater(int feeWater) {
        this.feeWater = feeWater;
    }


    @Column(name = "fee_electric", nullable = false, length = 10, precision = 0)
    public int getFeeElectric() {
        return feeElectric;
    }

    public void setFeeElectric(int feeElectric) {
        this.feeElectric = feeElectric;
    }


    @Column(name = "fee_gas", nullable = false, length = 10, precision = 0)
    public int getFeeGas() {
        return feeGas;
    }

    public void setFeeGas(int feeGas) {
        this.feeGas = feeGas;
    }


    @Column(name = "fee_property", nullable = false, length = 10, precision = 0)
    public int getFeeProperty() {
        return feeProperty;
    }

    public void setFeeProperty(int feeProperty) {
        this.feeProperty = feeProperty;
    }


    @Column(name = "dues_union", nullable = false, length = 10, precision = 0)
    public int getDuesUnion() {
        return duesUnion;
    }

    public void setDuesUnion(int duesUnion) {
        this.duesUnion = duesUnion;
    }


    @Column(name = "tax_income", nullable = false, length = 10, precision = 0)
    public int getTaxIncome() {
        return taxIncome;
    }

    public void setTaxIncome(int taxIncome) {
        this.taxIncome = taxIncome;
    }


    @Column(name = "tax_stamp", nullable = false, length = 10, precision = 0)
    public int getTaxStamp() {
        return taxStamp;
    }

    public void setTaxStamp(int taxStamp) {
        this.taxStamp = taxStamp;
    }


    @Column(name = "cost_rent", nullable = false, length = 10, precision = 0)
    public int getCostRent() {
        return costRent;
    }

    public void setCostRent(int costRent) {
        this.costRent = costRent;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Deduct that = (Deduct) o;
//
//        if (id != that.id) return false;
//        if (costRent != null ? !costRent.equals(that.costRent) : that.costRent != null) return false;
//        if (duesUnion != null ? !duesUnion.equals(that.duesUnion) : that.duesUnion != null) return false;
//        if (emplSn != null ? !emplSn.equals(that.emplSn) : that.emplSn != null) return false;
//        if (feeElectric != null ? !feeElectric.equals(that.feeElectric) : that.feeElectric != null) return false;
//        if (feeGas != null ? !feeGas.equals(that.feeGas) : that.feeGas != null) return false;
//        if (feeProperty != null ? !feeProperty.equals(that.feeProperty) : that.feeProperty != null) return false;
//        if (feeWater != null ? !feeWater.equals(that.feeWater) : that.feeWater != null) return false;
//        if (fundHouse != null ? !fundHouse.equals(that.fundHouse) : that.fundHouse != null) return false;
//        if (insuLqmed != null ? !insuLqmed.equals(that.insuLqmed) : that.insuLqmed != null) return false;
//        if (insuMedical != null ? !insuMedical.equals(that.insuMedical) : that.insuMedical != null) return false;
//        if (insuPension != null ? !insuPension.equals(that.insuPension) : that.insuPension != null) return false;
//        if (insuUnempl != null ? !insuUnempl.equals(that.insuUnempl) : that.insuUnempl != null) return false;
//        if (lastupdate != null ? !lastupdate.equals(that.lastupdate) : that.lastupdate != null) return false;
//        if (taxIncome != null ? !taxIncome.equals(that.taxIncome) : that.taxIncome != null) return false;
//        if (taxStamp != null ? !taxStamp.equals(that.taxStamp) : that.taxStamp != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (emplSn != null ? emplSn.hashCode() : 0);
//        result = 31 * result + (insuPension != null ? insuPension.hashCode() : 0);
//        result = 31 * result + (insuMedical != null ? insuMedical.hashCode() : 0);
//        result = 31 * result + (insuUnempl != null ? insuUnempl.hashCode() : 0);
//        result = 31 * result + (insuLqmed != null ? insuLqmed.hashCode() : 0);
//        result = 31 * result + (fundHouse != null ? fundHouse.hashCode() : 0);
//        result = 31 * result + (feeWater != null ? feeWater.hashCode() : 0);
//        result = 31 * result + (feeElectric != null ? feeElectric.hashCode() : 0);
//        result = 31 * result + (feeGas != null ? feeGas.hashCode() : 0);
//        result = 31 * result + (feeProperty != null ? feeProperty.hashCode() : 0);
//        result = 31 * result + (duesUnion != null ? duesUnion.hashCode() : 0);
//        result = 31 * result + (taxIncome != null ? taxIncome.hashCode() : 0);
//        result = 31 * result + (taxStamp != null ? taxStamp.hashCode() : 0);
//        result = 31 * result + (costRent != null ? costRent.hashCode() : 0);
//        result = 31 * result + (lastupdate != null ? lastupdate.hashCode() : 0);
//        return result;
//    }
}
