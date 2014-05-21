package com.haiso.hr.entity.datamapping;

import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Heli on 2014/5/16.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "P_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("WORKBOOK")
@Table(name = "t_dom")
public class ExcelWorkbookModel {

    @Id
    @GeneratedValue
    private Integer id;
    private String filePath;
    private String fileName;
    private String originalName;
    private Date uploadDate;
    @ManyToOne
    private Employee manager;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
