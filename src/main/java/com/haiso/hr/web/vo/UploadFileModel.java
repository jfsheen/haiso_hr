package com.haiso.hr.web.vo;

/**
 * Created by Heli on 2014/5/16.
 */
public class UploadFileModel {
    private int length;
    private byte[] bytes;
    private String name;
    private String contentType;

    public UploadFileModel() {
    }

    public UploadFileModel(int length, byte[] bytes, String name, String contentType) {
        this.length = length;
        this.bytes = bytes;
        this.name = name;
        this.contentType = contentType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
