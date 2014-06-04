package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;
import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 * 员工工资调整记录
 */
@Entity
@Table(name = "t_empl_salary_adjust")
public class Adjustment extends AuditBaseEntity{

    @Basic
    @Column(name = "amount")
    private Long amount; //单位为:li
    @Basic
    @Column(name = "remark")
    private String remark; //备注，必填
    @Basic
    @Column(name = "time_adjust")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeAdjust;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public java.util.Date getTimeAdjust() {
        return timeAdjust;
    }

    public void setTimeAdjust(java.util.Date timeAdjust) {
        this.timeAdjust = timeAdjust;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(amount, remark, timeAdjust, employee);
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
        final Adjustment other = (Adjustment) obj;
        return Objects.equal(this.amount, other.amount) && Objects.equal(this.remark, other.remark) && Objects.equal(this.timeAdjust, other.timeAdjust) && Objects.equal(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("amount", amount)
                .add("remark", remark)
                .add("timeAdjust", timeAdjust)
                .add("employee", employee)
                .toString();
    }
}
