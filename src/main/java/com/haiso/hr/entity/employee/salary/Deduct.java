package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by ff on 4/15/14.
 * 工资应扣记录
 */
@Embeddable
public class Deduct{

    @Basic
    @Column(name = "insu_pension")
    private Long insuPension;

    @Basic
    @Column(name = "insu_medical")
    private Long insuMedical;

    @Basic
    @Column(name = "insu_unempl")
    private Long insuUnempl;

    @Basic
    @Column(name = "insu_lqmed")
    private Long insuLqmed;

    @Basic
    @Column(name = "fund_house")
    private Long fundHouse;

    @Basic
    @Column(name = "fee_water")
    private Long feeWater;

    @Basic
    @Column(name = "fee_electric")
    private Long feeElectric;

    @Basic
    @Column(name = "fee_gas")
    private Long feeGas;

    @Basic
    @Column(name = "fee_property")
    private Long feeProperty;

    @Basic
    @Column(name = "dues_union")
    private Long duesUnion;

    @Basic
    @Column(name = "tax_income")
    private Long taxIncome;

    @Basic
    @Column(name = "tax_stamp")
    private Long taxStamp;

    @Basic
    @Column(name = "cost_rent")
    private Long costRent;

    @Basic
    @Column(name="fee_union")
    private Long feeUnion;

    public Long getFeeUnion() {
        return feeUnion;
    }

    public void setFeeUnion(Long feeUnion) {
        this.feeUnion = feeUnion;
    }

    public Long getInsuPension() {
        return insuPension;
    }

    public void setInsuPension(Long insuPension) {
        this.insuPension = insuPension;
    }


    public Long getInsuMedical() {
        return insuMedical;
    }

    public void setInsuMedical(Long insuMedical) {
        this.insuMedical = insuMedical;
    }


    public Long getInsuUnempl() {
        return insuUnempl;
    }

    public void setInsuUnempl(Long insuUnempl) {
        this.insuUnempl = insuUnempl;
    }


    public Long getInsuLqmed() {
        return insuLqmed;
    }

    public void setInsuLqmed(Long insuLqmed) {
        this.insuLqmed = insuLqmed;
    }


    public Long getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(Long fundHouse) {
        this.fundHouse = fundHouse;
    }


    public Long getFeeWater() {
        return feeWater;
    }

    public void setFeeWater(Long feeWater) {
        this.feeWater = feeWater;
    }


    public Long getFeeElectric() {
        return feeElectric;
    }

    public void setFeeElectric(Long feeElectric) {
        this.feeElectric = feeElectric;
    }


    public Long getFeeGas() {
        return feeGas;
    }

    public void setFeeGas(Long feeGas) {
        this.feeGas = feeGas;
    }


    public Long getFeeProperty() {
        return feeProperty;
    }

    public void setFeeProperty(Long feeProperty) {
        this.feeProperty = feeProperty;
    }


    public Long getDuesUnion() {
        return duesUnion;
    }

    public void setDuesUnion(Long duesUnion) {
        this.duesUnion = duesUnion;
    }


    public Long getTaxIncome() {
        return taxIncome;
    }

    public void setTaxIncome(Long taxIncome) {
        this.taxIncome = taxIncome;
    }


    public Long getTaxStamp() {
        return taxStamp;
    }

    public void setTaxStamp(Long taxStamp) {
        this.taxStamp = taxStamp;
    }


    public Long getCostRent() {
        return costRent;
    }

    public void setCostRent(Long costRent) {
        this.costRent = costRent;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(insuPension, insuMedical, insuUnempl, insuLqmed, fundHouse, feeWater, feeElectric, feeGas, feeProperty, duesUnion, taxIncome, taxStamp, costRent, feeUnion);
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
        return Objects.equal(this.insuPension, other.insuPension) && Objects.equal(this.insuMedical, other.insuMedical) && Objects.equal(this.insuUnempl, other.insuUnempl) && Objects.equal(this.insuLqmed, other.insuLqmed) && Objects.equal(this.fundHouse, other.fundHouse) && Objects.equal(this.feeWater, other.feeWater) && Objects.equal(this.feeElectric, other.feeElectric) && Objects.equal(this.feeGas, other.feeGas) && Objects.equal(this.feeProperty, other.feeProperty) && Objects.equal(this.duesUnion, other.duesUnion) && Objects.equal(this.taxIncome, other.taxIncome) && Objects.equal(this.taxStamp, other.taxStamp) && Objects.equal(this.costRent, other.costRent) && Objects.equal(this.feeUnion, other.feeUnion);
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
                .add("feeUnion", feeUnion)
                .toString();
    }
}
