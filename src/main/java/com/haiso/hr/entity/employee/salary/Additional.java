package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;

/**
 * Created by ff on 5/28/14.
 */
@Entity
@Table(name = "t_salary_add")
public class Additional extends AuditBaseEntity{

    @Basic
    @Column(name = "is_buckle")
    private Boolean isBuckle;
    @Basic
    @Column(name = "amount")
    private Long amount;
    @Basic
    @Column(name = "remark")
    private String remark;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(isBuckle, amount, remark, salary);
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
        final Additional other = (Additional) obj;
        return Objects.equal(this.isBuckle, other.isBuckle) && Objects.equal(this.amount, other.amount) && Objects.equal(this.remark, other.remark) && Objects.equal(this.salary, other.salary);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("isBuckle", isBuckle)
                .add("amount", amount)
                .add("remark", remark)
                .add("salary", salary)
                .toString();
    }

    public Boolean getIsBuckle() {
        return isBuckle;
    }

    public void setIsBuckle(Boolean isBuckle) {
        this.isBuckle = isBuckle;
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

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    

}
