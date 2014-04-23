package com.haiso.hr.entity.person;

import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/3/14.
 * 个人信息表
 */
@Entity
@Table(name = "t_person")
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
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "photo_path", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }


    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
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


    @Column(name = "partisan", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getPartisan() {
        return partisan;
    }

    public void setPartisan(String partisan) {
        this.partisan = partisan;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "join_party_date", nullable = true, insertable = true, updatable = true, length = 1)
    public Date getJoinPartyDate() {
        return joinPartyDate;
    }

    public void setJoinPartyDate(Date partyDate) {
        this.joinPartyDate = partyDate;
    }


    @Column(name = "hometown", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }


    @Column(name = "postal_code", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalcode) {
        this.postalCode = postalcode;
    }


    @Column(name = "mobile", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "qq", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }


    @Column(name = "weixin", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }


    @Column(name = "introduction", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    @Column(name = "last_degree", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getLastDegree() {
        return lastDegree;
    }

    public void setLastDegree(String lastDegree) {
        this.lastDegree = lastDegree;
    }


    @Column(name = "last_school", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getLastSchool() {
        return lastSchool;
    }

    public void setLastSchool(String lastSchool) {
        this.lastSchool = lastSchool;
    }


    @Column(name = "last_major", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getLastMajor() {
        return lastMajor;
    }

    public void setLastMajor(String lastMajor) {
        this.lastMajor = lastMajor;
    }


    @Column(name = "resi_address", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getResidentailAddress() {
        return residentailAddress;
    }

    public void setResidentailAddress(String currentAddress) {
        this.residentailAddress = currentAddress;
    }


    @Column(name = "ec_name", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }


    @Column(name = "ec_phone", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }


    @Column(name = "ec_address", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public String getEmergencyContactAddress() {
        return emergencyContactAddress;
    }

    public void setEmergencyContactAddress(String emergencyContactAddress) {
        this.emergencyContactAddress = emergencyContactAddress;
    }


    @Column(name = "sp_name", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }


    @Column(name = "sp_phone", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public String getSponsorPhone() {
        return sponsorPhone;
    }

    public void setSponsorPhone(String sponsorPhone) {
        this.sponsorPhone = sponsorPhone;
    }


    private Date lastUpdate;
    private Date createDate;
    private int version;

    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
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

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
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

//    @Override
//    public java.util.Date getCreatedDate() {
//        return null;
//    }
//
//    @Override
//    public void setCreatedDate(java.util.Date createdDate) {
//
//    }
//
//    @Override
//    public java.util.Date getLastUpdated() {
//        return null;
//    }
//
//    @Override
//    public void setLastUpdated(java.util.Date lastUpdatedDate) {
//
//    }
//
//    @Override
//    public int hashCode() {
//        int ret = HashCodeUtil.SEED;
//        ret = HashCodeUtil.hash(ret, id);
//        ret = HashCodeUtil.hash(ret, name);
//        ret = HashCodeUtil.hash(ret, idcardNum);
//        ret = HashCodeUtil.hash(ret, idcardPath);
//        ret = HashCodeUtil.hash(ret, photoPath);
//        ret = HashCodeUtil.hash(ret, name);
//        ret = HashCodeUtil.hash(ret, ethinic);
//        ret = HashCodeUtil.hash(ret, partisan);
//        ret = HashCodeUtil.hash(ret, joinPartyDate);
//        ret = HashCodeUtil.hash(ret, hometown);
//        ret = HashCodeUtil.hash(ret, address);
//        ret = HashCodeUtil.hash(ret, mobile);
//        ret = HashCodeUtil.hash(ret, postalcode);
//        ret = HashCodeUtil.hash(ret, phone);
//        ret = HashCodeUtil.hash(ret, email);
//        ret = HashCodeUtil.hash(ret, qq);
//        ret = HashCodeUtil.hash(ret, weixin);
//        ret = HashCodeUtil.hash(ret, introduction);
//        return ret;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person2 personInfo = (Person2) o;
//
//        if (id != personInfo.id) return false;
//        if (address != null ? !address.equals(personInfo.address) : personInfo.address != null) return false;
//        if (email != null ? !email.equals(personInfo.email) : personInfo.email != null) return false;
//        if (emplSn != null ? !emplSn.equals(personInfo.emplSn) : personInfo.emplSn != null) return false;
//        if (ethinic != null ? !ethinic.equals(personInfo.ethinic) : personInfo.ethinic != null) return false;
//        if (hometown != null ? !hometown.equals(personInfo.hometown) : personInfo.hometown != null) return false;
//        if (idcardNum != null ? !idcardNum.equals(personInfo.idcardNum) : personInfo.idcardNum != null) return false;
//        if (idcardPath != null ? !idcardPath.equals(personInfo.idcardPath) : personInfo.idcardPath != null) return false;
//        if (introduction != null ? !introduction.equals(personInfo.introduction) : personInfo.introduction != null) return false;
//        if (mobile != null ? !mobile.equals(personInfo.mobile) : personInfo.mobile != null) return false;
//        if (name != null ? !name.equals(personInfo.name) : personInfo.name != null) return false;
//        if (partisan != null ? !partisan.equals(personInfo.partisan) : personInfo.partisan != null) return false;
//        if (joinPartyDate != null ? !joinPartyDate.equals(personInfo.joinPartyDate) : personInfo.joinPartyDate != null) return false;
//        if (phone != null ? !phone.equals(personInfo.phone) : personInfo.phone != null) return false;
//        if (photoPath != null ? !photoPath.equals(personInfo.photoPath) : personInfo.photoPath != null) return false;
//        if (postalcode != null ? !postalcode.equals(personInfo.postalcode) : personInfo.postalcode != null) return false;
//        if (qq != null ? !qq.equals(personInfo.qq) : personInfo.qq != null) return false;
//        if (weixin != null ? !weixin.equals(personInfo.weixin) : personInfo.weixin != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
