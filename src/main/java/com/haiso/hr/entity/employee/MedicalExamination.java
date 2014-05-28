package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;
import com.haiso.hr.entity.person.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 5/4/14.
 */
@Entity
@Table(name = "t_med_exam")
public class MedicalExamination extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = true)
    private Person examPerson;
    @Basic
    @Column(name = "exam_date")
    @Temporal(TemporalType.DATE)
    private Date examDate;
    @Basic
    @Column(name = "hospital")
    private String hospital;
    @Basic
    @Column(name = "hspl_cncls")
    private String hospitalConclusion;
    @Basic
    @Column(name = "cod_cncls")
    private String coDoctorConclusion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "empl_id", nullable = true)
    private Employee coDoctor;
    @Basic
    @Column(name = "remark")
    private String remark;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("examPerson", examPerson)
                .add("examDate", examDate)
                .add("hospital", hospital)
                .add("hospitalConclusion", hospitalConclusion)
                .add("coDoctorConclusion", coDoctorConclusion)
                .add("coDoctor", coDoctor)
                .add("remark", remark)
                .toString();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(examPerson, examDate, hospital, hospitalConclusion, coDoctorConclusion, coDoctor, remark);
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
        final MedicalExamination other = (MedicalExamination) obj;
        return Objects.equal(this.examPerson, other.examPerson) && Objects.equal(this.examDate, other.examDate) && Objects.equal(this.hospital, other.hospital) && Objects.equal(this.hospitalConclusion, other.hospitalConclusion) && Objects.equal(this.coDoctorConclusion, other.coDoctorConclusion) && Objects.equal(this.coDoctor, other.coDoctor) && Objects.equal(this.remark, other.remark);
    }

    public Person getExamPerson() {
        return examPerson;
    }

    public void setExamPerson(Person examPerson) {
        this.examPerson = examPerson;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getHospitalConclusion() {
        return hospitalConclusion;
    }

    public void setHospitalConclusion(String hospitalConclusion) {
        this.hospitalConclusion = hospitalConclusion;
    }

    public String getCoDoctorConclusion() {
        return coDoctorConclusion;
    }

    public void setCoDoctorConclusion(String coDoctorConclusion) {
        this.coDoctorConclusion = coDoctorConclusion;
    }

    public Employee getCoDoctor() {
        return coDoctor;
    }

    public void setCoDoctor(Employee coDoctor) {
        this.coDoctor = coDoctor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }



}
