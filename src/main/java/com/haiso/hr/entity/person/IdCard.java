package com.haiso.hr.entity.person;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by ff on 4/23/14.
 */
@Embeddable
public class IdCard {

    private String idCardNum;
    private String idName;
    private boolean gender;
    private String idAddress;
    private String ethnic;
    private String idCardPicPath;
    private String issueAuth;
    private Date validStart;
    private Date validUntil;

    @Column(name = "idcard_num", nullable = true, length = 18)
    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    @Column(name = "idcard_name", nullable = true, length = 10)
    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    @Column(name = "idcard_gender", nullable = true, length = 1)
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Column(name = "idcard_address", nullable = true, length = 50)
    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    @Column(name = "idcard_ethnic", nullable = true, length = 10)
    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    @Column(name = "idcard_path", nullable = true, length = 100)
    public String getIdCardPicPath() {
        return idCardPicPath;
    }

    public void setIdCardPicPath(String idCardPicPath) {
        this.idCardPicPath = idCardPicPath;
    }

    @Column(name = "issue_auth", nullable = true, length = 20)
    public String getIssueAuth() {
        return issueAuth;
    }

    public void setIssueAuth(String issueAuth) {
        this.issueAuth = issueAuth;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "valid_start", nullable = true, length = 1)
    public Date getValidStart() {
        return validStart;
    }

    public void setValidStart(Date validStart) {
        this.validStart = validStart;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "valid_until", nullable = true, length = 1)
    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
}
