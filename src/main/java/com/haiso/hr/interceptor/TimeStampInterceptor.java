package com.haiso.hr.interceptor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

/**
 * Created by ff on 4/17/14.
 */
public class TimeStampInterceptor extends EmptyInterceptor {


    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState,
                                Object[] previousState, String[] propertyNames, Type[] types) {
//        if (entity instanceof ITimeStamped) {
//            int indexOf = ArrayUtils.indexOf(propertyNames, "lastUpdated");
//            currentState[indexOf] = new Date();
//            return true;
//        }
        return false;
    }


    public boolean onSave(Object entity, Serializable id, Object[] state,
                          String[] propertyNames, Type[] types) {
//        if (entity instanceof ITimeStamped) {
//            int indexOf = ArrayUtils.indexOf(propertyNames, "createdDate");
//            state[indexOf] = new Date();
//            return true;
//        }
        return false;
    }
}
