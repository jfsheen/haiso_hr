package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;

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

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("insuPension", insuPension)
                .add("insuMedical", insuMedical)
                .add("insuUnempl", insuUnempl)
                .add("insuLqmed", insuLqmed)
                .add("fundHouse", fundHouse)
                .add("feeWater", feeWater)
                .add("feeElectric", feeElectric)
                .add("feeGas", feeGas)
                .add("feeProperty", feeProperty)
                .add("duesUnion", duesUnion)
                .add("taxIncome", taxIncome)
                .add("taxStamp", taxStamp)
                .add("costRent", costRent)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(insuPension, insuMedical, insuUnempl, insuLqmed, fundHouse, feeWater, feeElectric, feeGas, feeProperty, duesUnion, taxIncome, taxStamp, costRent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Deduct other = (Deduct) obj;
        return Objects.equal(this.insuPension, other.insuPension) && Objects.equal(this.insuMedical, other.insuMedical) && Objects.equal(this.insuUnempl, other.insuUnempl) && Objects.equal(this.insuLqmed, other.insuLqmed) && Objects.equal(this.fundHouse, other.fundHouse) && Objects.equal(this.feeWater, other.feeWater) && Objects.equal(this.feeElectric, other.feeElectric) && Objects.equal(this.feeGas, other.feeGas) && Objects.equal(this.feeProperty, other.feeProperty) && Objects.equal(this.duesUnion, other.duesUnion) && Objects.equal(this.taxIncome, other.taxIncome) && Objects.equal(this.taxStamp, other.taxStamp) && Objects.equal(this.costRent, other.costRent);
    }
}
