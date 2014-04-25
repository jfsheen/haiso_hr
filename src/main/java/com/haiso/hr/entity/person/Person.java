package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.employee.Employee;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ff on 4/3/14.
 * 个人信息表
 */
@Entity
@Table(name = "t_person")//, uniqueConstraints = @UniqueConstraint(columnNames = {"idcard_num","name"}))
public class Person {

    private long id;

    private IdCard idCard;
    private String name;
    private String photoPath;
    private String partisan;
    private Date joinPartyDate;
    private String hukouType;
    private String hometown;
    private String lastDegree;
    private String lastSchool;
    private String lastMajor;
    private String residentailAddress;
    private String postalCode;
    private String mobile;
    private String phone;
    private String email;
    private String qq;
    private String weixin;
    private String introduction;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String emergencyContactAddress;
    private String sponsorName;
    private String sponsorPhone;
    private Employee employee;

    @OneToOne(mappedBy = "person", optional = true)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Embedded
    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "photo_path", length = 100)

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }


    @Column(name = "name", length = 10, nullable = true)
    @NotNull
    @Size(min = 2, max = 20, message = "An name must contain between 2 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "hukou_type", nullable = true, length = 10)
    public String getHukouType() {
        return hukouType;
    }

    public void setHukouType(String hukouType) {
        this.hukouType = hukouType;
    }


    @Column(name = "partisan", nullable = true, length = 20)
    public String getPartisan() {
        return partisan;
    }

    public void setPartisan(String partisan) {
        this.partisan = partisan;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "join_party_date", nullable = true, length = 1)
    public Date getJoinPartyDate() {
        return joinPartyDate;
    }

    public void setJoinPartyDate(Date partyDate) {
        this.joinPartyDate = partyDate;
    }


    @Column(name = "hometown", nullable = true, length = 16)
    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }


    @Column(name = "postal_code", nullable = true, length = 6)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalcode) {
        this.postalCode = postalcode;
    }


    @Column(name = "mobile", nullable = true, length = 16)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Column(name = "phone", nullable = true, length = 16)
    //@Pattern(regexp = "[0-9][-\\s]{11,20}")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name = "email", nullable = true, length = 45)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "qq", nullable = true, length = 12)
    @Pattern(regexp = "^[1-9][0-9]{4,11}]")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }


    @Column(name = "weixin", nullable = true, length = 20)
    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }


    @Column(name = "introduction", nullable = true, length = 500)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    @Column(name = "last_degree", nullable = true, length = 20)
    public String getLastDegree() {
        return lastDegree;
    }

    public void setLastDegree(String lastDegree) {
        this.lastDegree = lastDegree;
    }


    @Column(name = "last_school", nullable = true, length = 20)
    public String getLastSchool() {
        return lastSchool;
    }

    public void setLastSchool(String lastSchool) {
        this.lastSchool = lastSchool;
    }


    @Column(name = "last_major", nullable = true, length = 20)
    public String getLastMajor() {
        return lastMajor;
    }

    public void setLastMajor(String lastMajor) {
        this.lastMajor = lastMajor;
    }


    @Column(name = "resi_address", nullable = true, length = 50)
    public String getResidentailAddress() {
        return residentailAddress;
    }

    public void setResidentailAddress(String currentAddress) {
        this.residentailAddress = currentAddress;
    }


    @Column(name = "ec_name", nullable = true, length = 10)
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }


    @Column(name = "ec_phone", nullable = true, length = 16)
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }


    @Column(name = "ec_address", nullable = true, length = 1)
    public String getEmergencyContactAddress() {
        return emergencyContactAddress;
    }

    public void setEmergencyContactAddress(String emergencyContactAddress) {
        this.emergencyContactAddress = emergencyContactAddress;
    }


    @Column(name = "sp_name", nullable = true, length = 10)
    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }


    @Column(name = "sp_phone", nullable = true, length = 1)
    public String getSponsorPhone() {
        return sponsorPhone;
    }

    public void setSponsorPhone(String sponsorPhone) {
        this.sponsorPhone = sponsorPhone;
    }


    private Date lastUpdate;
    private Date createDate;
    private int version;

    @Column(name = "last_update", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Version
    @Column(name = "version_lock", length = 10)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "create_date", nullable = false, updatable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new Date();
    }

    @PrePersist
    public void prePersist() {
        this.createDate = new Date();
        this.lastUpdate = new Date();
    }

    @PreRemove
    public void preRemove() {

    }

    @PostPersist
    public void postPersist() {

    }

    @PostLoad
    public void postLoad() {

    }

    @PostRemove
    public void postRemove() {

    }

    @PostUpdate
    public void postUpdate() {

    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("idCard", idCard)
                .add("name", name)
                .add("photoPath", photoPath)
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
                .add("emergencyContactName", emergencyContactName)
                .add("emergencyContactPhone", emergencyContactPhone)
                .add("emergencyContactAddress", emergencyContactAddress)
                .add("sponsorName", sponsorName)
                .add("sponsorPhone", sponsorPhone)
                .add("employee", employee)
                .add("lastUpdate", lastUpdate)
                .add("createDate", createDate)
                .add("version", version)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, idCard, name, photoPath, partisan, joinPartyDate, hukouType, hometown, lastDegree, lastSchool, lastMajor, residentailAddress, postalCode, mobile, phone, email, qq, weixin, introduction, emergencyContactName, emergencyContactPhone, emergencyContactAddress, sponsorName, sponsorPhone, employee, lastUpdate, createDate, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.idCard, other.idCard) && Objects.equal(this.name, other.name) && Objects.equal(this.photoPath, other.photoPath) && Objects.equal(this.partisan, other.partisan) && Objects.equal(this.joinPartyDate, other.joinPartyDate) && Objects.equal(this.hukouType, other.hukouType) && Objects.equal(this.hometown, other.hometown) && Objects.equal(this.lastDegree, other.lastDegree) && Objects.equal(this.lastSchool, other.lastSchool) && Objects.equal(this.lastMajor, other.lastMajor) && Objects.equal(this.residentailAddress, other.residentailAddress) && Objects.equal(this.postalCode, other.postalCode) && Objects.equal(this.mobile, other.mobile) && Objects.equal(this.phone, other.phone) && Objects.equal(this.email, other.email) && Objects.equal(this.qq, other.qq) && Objects.equal(this.weixin, other.weixin) && Objects.equal(this.introduction, other.introduction) && Objects.equal(this.emergencyContactName, other.emergencyContactName) && Objects.equal(this.emergencyContactPhone, other.emergencyContactPhone) && Objects.equal(this.emergencyContactAddress, other.emergencyContactAddress) && Objects.equal(this.sponsorName, other.sponsorName) && Objects.equal(this.sponsorPhone, other.sponsorPhone) && Objects.equal(this.employee, other.employee) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version);
    }
}
