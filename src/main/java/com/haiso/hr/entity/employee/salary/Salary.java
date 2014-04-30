package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.person.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/23/14.
 */
@Entity
@Table(name = "t_empl_salary")
public class Salary {
    private long id;
    private Person person;
    private Date periodStart;
    private Date periodEnd;
    private Pay pay;
    private Deduct deduct;

    @Embedded
    public Deduct getDeduct() {
        return deduct;
    }

    public void setDeduct(Deduct deduct) {
        this.deduct = deduct;
    }

    @Embedded
    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "period_start", nullable = false, length = 1)
    @Temporal(TemporalType.DATE)
    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    @Column(name = "period_end", nullable = false, length = 1)
    @Temporal(TemporalType.DATE)
    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("person", person)
                .add("periodStart", periodStart)
                .add("periodEnd", periodEnd)
                .add("pay", pay)
                .add("deduct", deduct)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, person, periodStart, periodEnd, pay, deduct);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Salary other = (Salary) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.person, other.person) && Objects.equal(this.periodStart, other.periodStart) && Objects.equal(this.periodEnd, other.periodEnd) && Objects.equal(this.pay, other.pay) && Objects.equal(this.deduct, other.deduct);
    }
}
