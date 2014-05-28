package com.haiso.hr.entity.event;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;
import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/23/14.
 */

@Entity
@Table(name = "t_empl_event")
public class Event extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "empl_sn", nullable = true)
    private Employee employee;
    @Basic
    @Column(name = "create_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic
    @Column(name = "date_start", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Basic
    @Column(name = "date_end", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_leader", nullable = true)
    private Employee deptLeader;
    @Basic
    @Column(name = "dept_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deptDate;
    @Basic
    @Column(name = "dept_opinion", length = 50)
    private String deptOpinion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hr_leader", nullable = true)
    private Employee hrLeader;
    @Basic
    @Column(name = "hr_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date hrDate;
    @Basic
    @Column(name = "hr_opinion", length = 50)
    private String hrOpinion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "com_leader", nullable = true)
    private Employee comLeader;
    @Basic
    @Column(name = "com_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date comDate;
    @Basic
    @Column(name = "com_opinion", length = 50)
    private String comOpinion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "event_manager", nullable = true)
    private Employee manager;
    @Basic
    @Column(name = "progress_percent")
    private Short progress;

    public Short getProgress() {
        return progress;
    }

    public void setProgress(Short progress) {
        this.progress = progress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getComLeader() {
        return comLeader;
    }

    public Employee getHrLeader() {
        return hrLeader;
    }

    public Employee getDeptLeader() {
        return deptLeader;
    }

    public Employee getManager() {
        return manager;
    }

    public void setDeptLeader(Employee deptLeader) {
        this.deptLeader = deptLeader;
    }

    public void setHrLeader(Employee hrLeader) {
        this.hrLeader = hrLeader;
    }

    public void setComLeader(Employee comLeader) {
        this.comLeader = comLeader;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(Date deptDate) {
        this.deptDate = deptDate;
    }

    public String getDeptOpinion() {
        return deptOpinion;
    }

    public void setDeptOpinion(String deptOpinion) {
        this.deptOpinion = deptOpinion;
    }

    public Date getHrDate() {
        return hrDate;
    }

    public void setHrDate(Date hrDate) {
        this.hrDate = hrDate;
    }

    public String getHrOpinion() {
        return hrOpinion;
    }

    public void setHrOpinion(String hrOpinion) {
        this.hrOpinion = hrOpinion;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public String getComOpinion() {
        return comOpinion;
    }

    public void setComOpinion(String comOpinion) {
        this.comOpinion = comOpinion;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("employee", employee)
                .add("createDate", createDate)
                .add("dateStart", dateStart)
                .add("dateEnd", dateEnd)
                .add("deptLeader", deptLeader)
                .add("deptDate", deptDate)
                .add("deptOpinion", deptOpinion)
                .add("hrLeader", hrLeader)
                .add("hrDate", hrDate)
                .add("hrOpinion", hrOpinion)
                .add("comLeader", comLeader)
                .add("comDate", comDate)
                .add("comOpinion", comOpinion)
                .add("manager", manager)
                .add("progress", progress)
                .toString();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(employee, createDate, dateStart, dateEnd, deptLeader, deptDate, deptOpinion, hrLeader, hrDate, hrOpinion, comLeader, comDate, comOpinion, manager, progress);
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
        final Event other = (Event) obj;
        return Objects.equal(this.employee, other.employee) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.dateStart, other.dateStart) && Objects.equal(this.dateEnd, other.dateEnd) && Objects.equal(this.deptLeader, other.deptLeader) && Objects.equal(this.deptDate, other.deptDate) && Objects.equal(this.deptOpinion, other.deptOpinion) && Objects.equal(this.hrLeader, other.hrLeader) && Objects.equal(this.hrDate, other.hrDate) && Objects.equal(this.hrOpinion, other.hrOpinion) && Objects.equal(this.comLeader, other.comLeader) && Objects.equal(this.comDate, other.comDate) && Objects.equal(this.comOpinion, other.comOpinion) && Objects.equal(this.manager, other.manager) && Objects.equal(this.progress, other.progress);
    }
}
