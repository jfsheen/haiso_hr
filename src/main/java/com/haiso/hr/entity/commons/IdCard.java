package com.haiso.hr.entity.commons;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/23/14.
 */
@Embeddable
public class IdCard {

    @Basic
    @Column(name = "idcard_num")
    private String idCardNum;
    @Basic
    @Column(name = "idcard_name")
    private String idName;
    @Basic
    @Column(name = "idcard_gender")
    private Boolean idGender;

    @AttributeOverrides({@AttributeOverride(name="country", column=@Column(name="id_add_country")),
            @AttributeOverride(name="province", column=@Column(name="id_add_province")),
            @AttributeOverride(name="city", column=@Column(name="id_add_city")),
            @AttributeOverride(name="district", column=@Column(name="id_add_district")),
            @AttributeOverride(name="street", column=@Column(name="id_add_street")),
            @AttributeOverride(name="details", column=@Column(name="id_add_details")),
            @AttributeOverride(name="zip", column=@Column(name="id_add_zip"))
    })
    @Embedded
    private Address idAddress;

    @Basic
    @Column(name = "idcard_ethnic")
    private String idEthnic;
    @Basic
    @Column(name = "idcard_path")
    private String idCardPicPath;
    @Basic
    @Column(name = "issue_auth")
    private String idIssueAuth;
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "valid_start")
    private Date idValidStart;
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "valid_until")
    private Date idValidUntil;

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public Boolean getIdGender() {
        return idGender;
    }

    public void setIdGender(Boolean idGender) {
        this.idGender = idGender;
    }

    public String getIdEthnic() {
        return idEthnic;
    }

    public void setIdEthnic(String idEthnic) {
        this.idEthnic = idEthnic;
    }

    public String getIdCardPicPath() {
        return idCardPicPath;
    }

    public void setIdCardPicPath(String idCardPicPath) {
        this.idCardPicPath = idCardPicPath;
    }

    public String getIdIssueAuth() {
        return idIssueAuth;
    }

    public void setIdIssueAuth(String idIssueAuth) {
        this.idIssueAuth = idIssueAuth;
    }

    public Date getIdValidStart() {
        return idValidStart;
    }

    public void setIdValidStart(Date idValidStart) {
        this.idValidStart = idValidStart;
    }

    public Date getIdValidUntil() {
        return idValidUntil;
    }

    public void setIdValidUntil(Date idValidUntil) {
        this.idValidUntil = idValidUntil;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCardNum, idName, idGender, idAddress, idEthnic, idCardPicPath, idIssueAuth, idValidStart, idValidUntil);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final IdCard other = (IdCard) obj;
        return Objects.equal(this.idCardNum, other.idCardNum) && Objects.equal(this.idName, other.idName) && Objects.equal(this.idGender, other.idGender) && Objects.equal(this.idAddress, other.idAddress) && Objects.equal(this.idEthnic, other.idEthnic) && Objects.equal(this.idCardPicPath, other.idCardPicPath) && Objects.equal(this.idIssueAuth, other.idIssueAuth) && Objects.equal(this.idValidStart, other.idValidStart) && Objects.equal(this.idValidUntil, other.idValidUntil);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("idCardNum", idCardNum)
                .add("idName", idName)
                .add("idGender", idGender)
                .add("idAddress", idAddress)
                .add("idEthnic", idEthnic)
                .add("idCardPicPath", idCardPicPath)
                .add("idIssueAuth", idIssueAuth)
                .add("idValidStart", idValidStart)
                .add("idValidUntil", idValidUntil)
                .toString();
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }
}
