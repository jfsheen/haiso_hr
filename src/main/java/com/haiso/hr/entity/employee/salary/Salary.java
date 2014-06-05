package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;
import com.haiso.hr.entity.person.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/23/14.
 */
@Entity
@Table(name = "t_empl_salary")
public class Salary extends AuditBaseEntity{

    @Basic
    @Column(name = "period_start")
    @Temporal(TemporalType.DATE)
    private Date periodStart;

    @Basic
    @Column(name = "period_end")
    @Temporal(TemporalType.DATE)
    private Date periodEnd;

    @Embedded
    private Pay pay;

    @Embedded
    private Deduct deduct;

    @Basic
    @Column(name="real_salary")
    private Long realSalary;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;

    public Deduct getDeduct() {
        return deduct;
    }

    public void setDeduct(Deduct deduct) {
        this.deduct = deduct;
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(periodStart, periodEnd, pay, deduct, realSalary, person);
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
        final Salary other = (Salary) obj;
        return Objects.equal(this.periodStart, other.periodStart) && Objects.equal(this.periodEnd, other.periodEnd) && Objects.equal(this.pay, other.pay) && Objects.equal(this.deduct, other.deduct) && Objects.equal(this.realSalary, other.realSalary) && Objects.equal(this.person, other.person);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("periodStart", periodStart)
                .add("periodEnd", periodEnd)
                .add("pay", pay)
                .add("deduct", deduct)
                .add("realSalary", realSalary)
                .add("person", person)
                .toString();
    }

    public Long getRealSalary() {
        return realSalary;
    }

    public void setRealSalary(Long realSalary) {
        this.realSalary = realSalary;
    }
}
