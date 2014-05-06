package com.haiso.hr.entity.param;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/21/14.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "P_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("G")
@Table(name = "t_param")
public abstract class Param {

    private Integer id;
    private String pKey;
    private String pValue;
    private String defaultValue;
    private String explanation;
    private String description;
    private Date createDate;
    private Date lastUpdate;
    private Integer version;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "default_value", length = 20)
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }


    @Version
    @Column(name = "version_lock", length = 10)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    @Column(name = "create_date", nullable = false, updatable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }


    @Column(name = "last_update", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new java.util.Date();
    }

    @PrePersist
    public void prePersist() {
        this.createDate = new java.util.Date();
        this.lastUpdate = new java.util.Date();
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

    @Column(name = "para_key", nullable = false, length = 20)
    public String getpKey() {
        return pKey;
    }

    public void setpKey(String pKey) {
        this.pKey = pKey;
    }

    @Column(name = "para_value", nullable = false, length = 50)
    public String getpValue() {
        return pValue;
    }

    public void setpValue(String pValue) {
        this.pValue = pValue;
    }

    @Column(name = "explanation", nullable = true, length = 200)
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, pKey, pValue, defaultValue, explanation, description, createDate, lastUpdate, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Param other = (Param) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.pKey, other.pKey) && Objects.equal(this.pValue, other.pValue) && Objects.equal(this.defaultValue, other.defaultValue) && Objects.equal(this.explanation, other.explanation) && Objects.equal(this.description, other.description) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.version, other.version);
    }
}
