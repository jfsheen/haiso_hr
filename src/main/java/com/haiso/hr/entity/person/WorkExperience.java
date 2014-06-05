package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;
import com.haiso.hr.entity.commons.Address;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 个人工作简历表
 */
@Entity
@Table(name = "t_prsn_wrkexp")
public class WorkExperience extends BaseEntity{
    @Basic
    @Column(name = "company")
    private String companyName;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "com_phone")
    private String companyPhone;

    @AttributeOverrides({@AttributeOverride(name="country", column=@Column(name="com_country")),
            @AttributeOverride(name="province", column=@Column(name="com_province")),
            @AttributeOverride(name="city", column=@Column(name="com_city")),
            @AttributeOverride(name="district", column=@Column(name="com_district")),
            @AttributeOverride(name="street", column=@Column(name="com_street")),
            @AttributeOverride(name="details", column=@Column(name="com_details")),
            @AttributeOverride(name="zip", column=@Column(name="com_zip"))
    })
    @Embedded
    private Address comAddress;
    
    @Basic
    @Column(name = "website_add")
    private String websiteAddress;
    @Basic
    @Column(name = "com_email")
    private String companyEmail;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String company) {
        this.companyName = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(companyName, position, startDate, endDate, companyPhone, comAddress, websiteAddress, companyEmail, person);
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
        final WorkExperience other = (WorkExperience) obj;
        return Objects.equal(this.companyName, other.companyName) && Objects.equal(this.position, other.position) && Objects.equal(this.startDate, other.startDate) && Objects.equal(this.endDate, other.endDate) && Objects.equal(this.companyPhone, other.companyPhone) && Objects.equal(this.comAddress, other.comAddress) && Objects.equal(this.websiteAddress, other.websiteAddress) && Objects.equal(this.companyEmail, other.companyEmail) && Objects.equal(this.person, other.person);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("companyName", companyName)
                .add("position", position)
                .add("startDate", startDate)
                .add("endDate", endDate)
                .add("companyPhone", companyPhone)
                .add("comAddress", comAddress)
                .add("websiteAddress", websiteAddress)
                .add("companyEmail", companyEmail)
                .add("person", person)
                .toString();
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public Address getComAddress() {
        return comAddress;
    }

    public void setComAddress(Address comAddress) {
        this.comAddress = comAddress;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
