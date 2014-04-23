package com.haiso.hr.entity.listeners;

import javax.persistence.PrePersist;

/**
 * Created by ff on 4/18/14.
 */
public abstract class LastupdateListener<T> {
    @PrePersist
    public void prePersist(Object o) {

    }
}
