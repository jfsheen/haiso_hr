package com.haiso.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ff on 4/15/14.
 * 工资应扣记录
 */
@Entity
@Table(name = "t_salary_deduct")
public class EmplSalaryDeduct {
    private int id;
    private String emplSn;
    private BigDecimal insuPension;
    private BigDecimal insuMedical;
    private BigDecimal insuUnempl;
    private BigDecimal insuLqmed;
    private BigDecimal fundHouse;
    private BigDecimal feeWater;
    private BigDecimal feeElectric;
    private BigDecimal feeGas;
    private BigDecimal feeProperty;
    private BigDecimal duesUnion;
    private BigDecimal taxIncome;
    private BigDecimal taxStamp;
    private BigDecimal costRent;
    private Timestamp lastupdate;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "empl_sn", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getEmplSn() {
        return emplSn;
    }

    public void setEmplSn(String emplSn) {
        this.emplSn = emplSn;
    }

    @Basic
    @Column(name = "insu_pension", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getInsuPension() {
        return insuPension;
    }

    public void setInsuPension(BigDecimal insuPension) {
        this.insuPension = insuPension;
    }

    @Basic
    @Column(name = "insu_medical", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getInsuMedical() {
        return insuMedical;
    }

    public void setInsuMedical(BigDecimal insuMedical) {
        this.insuMedical = insuMedical;
    }

    @Basic
    @Column(name = "insu_unempl", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getInsuUnempl() {
        return insuUnempl;
    }

    public void setInsuUnempl(BigDecimal insuUnempl) {
        this.insuUnempl = insuUnempl;
    }

    @Basic
    @Column(name = "insu_lqmed", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getInsuLqmed() {
        return insuLqmed;
    }

    public void setInsuLqmed(BigDecimal insuLqmed) {
        this.insuLqmed = insuLqmed;
    }

    @Basic
    @Column(name = "fund_house", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(BigDecimal fundHouse) {
        this.fundHouse = fundHouse;
    }

    @Basic
    @Column(name = "fee_water", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getFeeWater() {
        return feeWater;
    }

    public void setFeeWater(BigDecimal feeWater) {
        this.feeWater = feeWater;
    }

    @Basic
    @Column(name = "fee_electric", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getFeeElectric() {
        return feeElectric;
    }

    public void setFeeElectric(BigDecimal feeElectric) {
        this.feeElectric = feeElectric;
    }

    @Basic
    @Column(name = "fee_gas", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getFeeGas() {
        return feeGas;
    }

    public void setFeeGas(BigDecimal feeGas) {
        this.feeGas = feeGas;
    }

    @Basic
    @Column(name = "fee_property", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getFeeProperty() {
        return feeProperty;
    }

    public void setFeeProperty(BigDecimal feeProperty) {
        this.feeProperty = feeProperty;
    }

    @Basic
    @Column(name = "dues_union", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getDuesUnion() {
        return duesUnion;
    }

    public void setDuesUnion(BigDecimal duesUnion) {
        this.duesUnion = duesUnion;
    }

    @Basic
    @Column(name = "tax_income", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getTaxIncome() {
        return taxIncome;
    }

    public void setTaxIncome(BigDecimal taxIncome) {
        this.taxIncome = taxIncome;
    }

    @Basic
    @Column(name = "tax_stamp", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getTaxStamp() {
        return taxStamp;
    }

    public void setTaxStamp(BigDecimal taxStamp) {
        this.taxStamp = taxStamp;
    }

    @Basic
    @Column(name = "cost_rent", nullable = false, insertable = true, updatable = true, length = 8, precision = 2)
    public BigDecimal getCostRent() {
        return costRent;
    }

    public void setCostRent(BigDecimal costRent) {
        this.costRent = costRent;
    }

    @Basic
    @Column(name = "lastupdate", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
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

        EmplSalaryDeduct that = (EmplSalaryDeduct) o;

        if (id != that.id) return false;
        if (costRent != null ? !costRent.equals(that.costRent) : that.costRent != null) return false;
        if (duesUnion != null ? !duesUnion.equals(that.duesUnion) : that.duesUnion != null) return false;
        if (emplSn != null ? !emplSn.equals(that.emplSn) : that.emplSn != null) return false;
        if (feeElectric != null ? !feeElectric.equals(that.feeElectric) : that.feeElectric != null) return false;
        if (feeGas != null ? !feeGas.equals(that.feeGas) : that.feeGas != null) return false;
        if (feeProperty != null ? !feeProperty.equals(that.feeProperty) : that.feeProperty != null) return false;
        if (feeWater != null ? !feeWater.equals(that.feeWater) : that.feeWater != null) return false;
        if (fundHouse != null ? !fundHouse.equals(that.fundHouse) : that.fundHouse != null) return false;
        if (insuLqmed != null ? !insuLqmed.equals(that.insuLqmed) : that.insuLqmed != null) return false;
        if (insuMedical != null ? !insuMedical.equals(that.insuMedical) : that.insuMedical != null) return false;
        if (insuPension != null ? !insuPension.equals(that.insuPension) : that.insuPension != null) return false;
        if (insuUnempl != null ? !insuUnempl.equals(that.insuUnempl) : that.insuUnempl != null) return false;
        if (lastupdate != null ? !lastupdate.equals(that.lastupdate) : that.lastupdate != null) return false;
        if (taxIncome != null ? !taxIncome.equals(that.taxIncome) : that.taxIncome != null) return false;
        if (taxStamp != null ? !taxStamp.equals(that.taxStamp) : that.taxStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (emplSn != null ? emplSn.hashCode() : 0);
        result = 31 * result + (insuPension != null ? insuPension.hashCode() : 0);
        result = 31 * result + (insuMedical != null ? insuMedical.hashCode() : 0);
        result = 31 * result + (insuUnempl != null ? insuUnempl.hashCode() : 0);
        result = 31 * result + (insuLqmed != null ? insuLqmed.hashCode() : 0);
        result = 31 * result + (fundHouse != null ? fundHouse.hashCode() : 0);
        result = 31 * result + (feeWater != null ? feeWater.hashCode() : 0);
        result = 31 * result + (feeElectric != null ? feeElectric.hashCode() : 0);
        result = 31 * result + (feeGas != null ? feeGas.hashCode() : 0);
        result = 31 * result + (feeProperty != null ? feeProperty.hashCode() : 0);
        result = 31 * result + (duesUnion != null ? duesUnion.hashCode() : 0);
        result = 31 * result + (taxIncome != null ? taxIncome.hashCode() : 0);
        result = 31 * result + (taxStamp != null ? taxStamp.hashCode() : 0);
        result = 31 * result + (costRent != null ? costRent.hashCode() : 0);
        result = 31 * result + (lastupdate != null ? lastupdate.hashCode() : 0);
        return result;
    }
}
