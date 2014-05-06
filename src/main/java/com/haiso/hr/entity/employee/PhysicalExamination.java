package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 5/4/14.
 */
@Entity
@Table(name = "t_empl_phy_exam")
public class PhysicalExamination {
    private Integer id;
    private Date examDate;
    private Employee employee;
    private String conclusion;
    private String remark;

    @Column(name = "conclusion")
    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "exam_date")
    @Temporal(TemporalType.DATE)
    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "empl_sn", nullable = true)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("examDate", examDate)
                .add("employee", employee)
                .add("conclusion", conclusion)
                .add("remark", remark)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, examDate, employee, conclusion, remark);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final PhysicalExamination other = (PhysicalExamination) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.examDate, other.examDate) && Objects.equal(this.employee, other.employee) && Objects.equal(this.conclusion, other.conclusion) && Objects.equal(this.remark, other.remark);
    }
}
