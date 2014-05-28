package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 员工合同记录
 */
@Entity
@Table(name = "t_empl_contract")
public class Contract extends BaseEntity {
    @Basic
    @Column(name = "contract_sn")
    private String contractSn;
    @Basic
    @Column(name = "contract_date")
    private Date contractDate;
    @Basic
    @Column(name = "expiry_date")
    private Date expiryDate;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "remark")
    private String remark;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn")
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String getContractSn() {
        return contractSn;
    }

    public void setContractSn(String contractSn) {
        this.contractSn = contractSn;
    }


    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }


    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("contractSn", contractSn)
                .add("contractDate", contractDate)
                .add("expiryDate", expiryDate)
                .add("location", location)
                .add("remark", remark)
                .add("employee", employee)
                .toString();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(contractSn, contractDate, expiryDate, location, remark, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final Contract other = (Contract) obj;
        return Objects.equal(this.contractSn, other.contractSn) && Objects.equal(this.contractDate, other.contractDate) && Objects.equal(this.expiryDate, other.expiryDate) && Objects.equal(this.location, other.location) && Objects.equal(this.remark, other.remark) && Objects.equal(this.employee, other.employee);
    }
}
