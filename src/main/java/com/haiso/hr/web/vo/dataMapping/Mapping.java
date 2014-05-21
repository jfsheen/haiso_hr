package com.haiso.hr.web.vo.dataMapping;

import java.util.Set;

/**
 * Created by ff on 5/21/14.
 */
public class Mapping {
    private String entityName;
    private String dataTitlesMapHashcode;
    private String mappingSetsHashcode;
    private Set<MappingEntry> mappingEntrySet;

    public Set<MappingEntry> getMappingEntrySet() {
        return mappingEntrySet;
    }

    public void setMappingEntrySet(Set<MappingEntry> mappingEntrySet) {
        this.mappingEntrySet = mappingEntrySet;
    }

    public String getDataTitlesMapHashcode() {
        return dataTitlesMapHashcode;
    }

    public void setDataTitlesMapHashcode(String dataTitlesMapHashcode) {
        this.dataTitlesMapHashcode = dataTitlesMapHashcode;
    }

    public String getMappingSetsHashcode() {
        return mappingSetsHashcode;
    }

    public void setMappingSetsHashcode(String mappingSetsHashcode) {
        this.mappingSetsHashcode = mappingSetsHashcode;
    }

    public Mapping(String entityName, String dataTitlesMapHashcode, String mappingSetsHashcode, Set<MappingEntry> mappingEntrySet) {

        this.entityName = entityName;
        this.dataTitlesMapHashcode = dataTitlesMapHashcode;
        this.mappingSetsHashcode = mappingSetsHashcode;
        this.mappingEntrySet = mappingEntrySet;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Mapping() {

    }
}
