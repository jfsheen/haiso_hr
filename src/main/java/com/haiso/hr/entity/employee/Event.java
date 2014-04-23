package com.haiso.hr.entity.employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/23/14.
 */

@Entity
@Table(name = "t_event")
public class Event {

    private long id;
    private Employee employee;
    private Date createDate;
    private Date dateStart;
    private Date dateEnd;
    private Employee deptLeader;
    private Date deptDate;
    private String deptOpinion;
    private Employee hrLeader;
    private Date hrDate;
    private String hrOpinion;

    private Employee comLeader;
    private Date comDate;
    private String comOpinion;
    private Employee manager;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "empl_sn", nullable = true)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "com_leader", nullable = true)
    public Employee getComLeader() {
        return comLeader;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hr_leader", nullable = true)
    public Employee getHrLeader() {
        return hrLeader;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_leader", nullable = true)
    public Employee getDeptLeader() {
        return deptLeader;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "event_manager", nullable = true)
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

    @Column(name = "create_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "date_start", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Column(name = "date_end", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }


    @Column(name = "dept_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(Date deptDate) {
        this.deptDate = deptDate;
    }

    @Column(name = "dept_opinion", length = 50)
    public String getDeptOpinion() {
        return deptOpinion;
    }

    public void setDeptOpinion(String deptOpinion) {
        this.deptOpinion = deptOpinion;
    }

    @Column(name = "hr_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getHrDate() {
        return hrDate;
    }

    public void setHrDate(Date hrDate) {
        this.hrDate = hrDate;
    }

    @Column(name = "hr_opinion", length = 50)
    public String getHrOpinion() {
        return hrOpinion;
    }

    public void setHrOpinion(String hrOpinion) {
        this.hrOpinion = hrOpinion;
    }


    @Column(name = "com_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    @Column(name = "com_opinion", length = 50)
    public String getComOpinion() {
        return comOpinion;
    }

    public void setComOpinion(String comOpinion) {
        this.comOpinion = comOpinion;
    }


}
