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

    private Integer insuPension;
    private Integer insuMedical;
    private Integer insuUnempl;
    private Integer insuLqmed;
    private Integer fundHouse;
    private Integer feeWater;
    private Integer feeElectric;
    private Integer feeGas;
    private Integer feeProperty;
    private Integer duesUnion;
    private Integer taxIncome;
    private Integer taxStamp;
    private Integer costRent;


    @Column(name = "insu_pension", nullable = false, length = 10, precision = 0)
    public Integer getInsuPension() {
        return insuPension;
    }

    public void setInsuPension(Integer insuPension) {
        this.insuPension = insuPension;
    }


    @Column(name = "insu_medical", nullable = false, length = 10, precision = 0)
    public Integer getInsuMedical() {
        return insuMedical;
    }

    public void setInsuMedical(Integer insuMedical) {
        this.insuMedical = insuMedical;
    }


    @Column(name = "insu_unempl", nullable = false, length = 10, precision = 0)
    public Integer getInsuUnempl() {
        return insuUnempl;
    }

    public void setInsuUnempl(Integer insuUnempl) {
        this.insuUnempl = insuUnempl;
    }


    @Column(name = "insu_lqmed", nullable = false, length = 10, precision = 0)
    public Integer getInsuLqmed() {
        return insuLqmed;
    }

    public void setInsuLqmed(Integer insuLqmed) {
        this.insuLqmed = insuLqmed;
    }


    @Column(name = "fund_house", nullable = false, length = 10, precision = 0)
    public Integer getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(Integer fundHouse) {
        this.fundHouse = fundHouse;
    }


    @Column(name = "fee_water", nullable = false, length = 10, precision = 0)
    public Integer getFeeWater() {
        return feeWater;
    }

    public void setFeeWater(Integer feeWater) {
        this.feeWater = feeWater;
    }


    @Column(name = "fee_electric", nullable = false, length = 10, precision = 0)
    public Integer getFeeElectric() {
        return feeElectric;
    }

    public void setFeeElectric(Integer feeElectric) {
        this.feeElectric = feeElectric;
    }


    @Column(name = "fee_gas", nullable = false, length = 10, precision = 0)
    public Integer getFeeGas() {
        return feeGas;
    }

    public void setFeeGas(Integer feeGas) {
        this.feeGas = feeGas;
    }


    @Column(name = "fee_property", nullable = false, length = 10, precision = 0)
    public Integer getFeeProperty() {
        return feeProperty;
    }

    public void setFeeProperty(Integer feeProperty) {
        this.feeProperty = feeProperty;
    }


    @Column(name = "dues_union", nullable = false, length = 10, precision = 0)
    public Integer getDuesUnion() {
        return duesUnion;
    }

    public void setDuesUnion(Integer duesUnion) {
        this.duesUnion = duesUnion;
    }


    @Column(name = "tax_income", nullable = false, length = 10, precision = 0)
    public Integer getTaxIncome() {
        return taxIncome;
    }

    public void setTaxIncome(Integer taxIncome) {
        this.taxIncome = taxIncome;
    }


    @Column(name = "tax_stamp", nullable = false, length = 10, precision = 0)
    public Integer getTaxStamp() {
        return taxStamp;
    }

    public void setTaxStamp(Integer taxStamp) {
        this.taxStamp = taxStamp;
    }


    @Column(name = "cost_rent", nullable = false, length = 10, precision = 0)
    public Integer getCostRent() {
        return costRent;
    }

    public void setCostRent(Integer costRent) {
        this.costRent = costRent;
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
