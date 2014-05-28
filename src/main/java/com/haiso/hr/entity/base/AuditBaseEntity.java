package com.haiso.hr.entity.base;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ff on 5/28/14.
 */
@MappedSuperclass
public abstract class AuditBaseEntity extends BaseEntity {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Size(max = 20)
    @Column(name = "created_by", length = 20)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Size(max = 20)
    @Column(name = "updated_by", length = 20)
    private String updatedBy;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Sets createdAt before insert
     */
    @PrePersist
    public void beforePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    /**
     * Sets updatedAt before update
     */
    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = new Date();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(createdAt, createdBy, updatedAt, updatedBy);
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
        final AuditBaseEntity other = (AuditBaseEntity) obj;
        return Objects.equal(this.createdAt, other.createdAt) && Objects.equal(this.createdBy, other.createdBy) && Objects.equal(this.updatedAt, other.updatedAt) && Objects.equal(this.updatedBy, other.updatedBy);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("createdAt", createdAt)
                .add("createdBy", createdBy)
                .add("updatedAt", updatedAt)
                .add("updatedBy", updatedBy)
                .toString();
    }
}
