package com.haiso.hr.entity.param;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ff on 4/22/14.
 */
@Entity
@DiscriminatorValue("EmpSeq")
public class EmplSequence extends Param {

    private int seq;

    @Column(name = "seq")
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
