package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;
import com.haiso.hr.entity.commons.Address;
import com.haiso.hr.entity.commons.IdCard;
import com.haiso.hr.entity.employee.Employee;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ff on 4/3/14.
 * 个人信息表
 */
@Entity
@Table(name = "t_person")//, uniqueConstraints = @UniqueConstraint(columnNames = {"idcard_num","name"}))
public class Person extends AuditBaseEntity{

    @Embedded
    private IdCard idCard;

    @Basic
    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 20, message = "An name must contain between 2 and 20 characters")
    private String name;

    @Basic
    @Column(name = "photo_path")
    private String photoPath;

    @Basic
    @Column(name = "married")
    private Boolean married;

    @Basic
    @Column(name = "partisan")
    private String partisan;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "join_party_date")
    private Date joinPartyDate;

    @Basic
    @Column(name = "hukou_type")
    private String hukouType;

    @Basic
    @Column(name = "hometown")
    private String hometown;

    @Basic
    @Column(name = "last_degree")
    private String lastDegree;

    @Basic
    @Column(name = "last_school")
    private String lastSchool;

    @Basic
    @Column(name = "last_major")
    private String lastMajor;

    @AttributeOverrides({@AttributeOverride(name="country", column=@Column(name="resi_country")),
            @AttributeOverride(name="province", column=@Column(name="resi_province")),
            @AttributeOverride(name="city", column=@Column(name="resi_city")),
            @AttributeOverride(name="district", column=@Column(name="resi_district")),
            @AttributeOverride(name="street", column=@Column(name="resi_street")),
            @AttributeOverride(name="details", column=@Column(name="resi_details")),
            @AttributeOverride(name="zip", column=@Column(name="resi_zip"))
    })
    @Embedded
    private Address residentailAddress;

    public Address getResidentailAddress() {
        return residentailAddress;
    }

    public void setResidentailAddress(Address residentailAddress) {
        this.residentailAddress = residentailAddress;
    }

    @Basic
    @Column(name = "postal_code")
    private String postalCode;

    @Basic
    @Column(name = "mobile")
    private String mobile;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "email")
    @Email
    private String email;

    @Basic
    @Column(name = "qq")
//    @Pattern(regexp = "^[1-9][0-9]{4,11}]")
    private String qq;

    @Basic
    @Column(name = "weixin")
    private String weixin;

    @Basic
    @Column(name = "introduction")
    private String introduction;

    @OneToOne(mappedBy = "person", optional = true)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHukouType() {
        return hukouType;
    }

    public void setHukouType(String hukouType) {
        this.hukouType = hukouType;
    }

    public String getPartisan() {
        return partisan;
    }

    public void setPartisan(String partisan) {
        this.partisan = partisan;
    }

    public Date getJoinPartyDate() {
        return joinPartyDate;
    }

    public void setJoinPartyDate(Date partyDate) {
        this.joinPartyDate = partyDate;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalcode) {
        this.postalCode = postalcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }


    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }


    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLastDegree() {
        return lastDegree;
    }

    public void setLastDegree(String lastDegree) {
        this.lastDegree = lastDegree;
    }

    public String getLastSchool() {
        return lastSchool;
    }

    public void setLastSchool(String lastSchool) {
        this.lastSchool = lastSchool;
    }


    public String getLastMajor() {
        return lastMajor;
    }

    public void setLastMajor(String lastMajor) {
        this.lastMajor = lastMajor;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(idCard, name, photoPath, married, partisan, joinPartyDate, hukouType, hometown, lastDegree, lastSchool, lastMajor, residentailAddress, postalCode, mobile, phone, email, qq, weixin, introduction, employee);
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
        final Person other = (Person) obj;
        return Objects.equal(this.idCard, other.idCard) && Objects.equal(this.name, other.name) && Objects.equal(this.photoPath, other.photoPath) && Objects.equal(this.married, other.married) && Objects.equal(this.partisan, other.partisan) && Objects.equal(this.joinPartyDate, other.joinPartyDate) && Objects.equal(this.hukouType, other.hukouType) && Objects.equal(this.hometown, other.hometown) && Objects.equal(this.lastDegree, other.lastDegree) && Objects.equal(this.lastSchool, other.lastSchool) && Objects.equal(this.lastMajor, other.lastMajor) && Objects.equal(this.residentailAddress, other.residentailAddress) && Objects.equal(this.postalCode, other.postalCode) && Objects.equal(this.mobile, other.mobile) && Objects.equal(this.phone, other.phone) && Objects.equal(this.email, other.email) && Objects.equal(this.qq, other.qq) && Objects.equal(this.weixin, other.weixin) && Objects.equal(this.introduction, other.introduction) && Objects.equal(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("idCard", idCard)
                .add("name", name)
                .add("photoPath", photoPath)
                .add("married", married)
                .add("partisan", partisan)
                .add("joinPartyDate", joinPartyDate)
                .add("hukouType", hukouType)
                .add("hometown", hometown)
                .add("lastDegree", lastDegree)
                .add("lastSchool", lastSchool)
                .add("lastMajor", lastMajor)
                .add("residentailAddress", residentailAddress)
                .add("postalCode", postalCode)
                .add("mobile", mobile)
                .add("phone", phone)
                .add("email", email)
                .add("qq", qq)
                .add("weixin", weixin)
                .add("introduction", introduction)
                .add("employee", employee)
                .toString();
    }
}
