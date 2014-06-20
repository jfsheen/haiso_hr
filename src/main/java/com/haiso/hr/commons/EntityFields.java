package com.haiso.hr.commons;

import com.haiso.commons.utils.data.entityHelper.vo.FieldNode;

/**
 * Created by ff on 6/10/14.
 */
public class EntityFields {
    public static FieldNode person = new FieldNode();
    static {

        person.setFieldName("Person");
        person.setDescription("person info");
        person.setFieldType("Person");
        person.getEmbeddedFields();
    }
}
