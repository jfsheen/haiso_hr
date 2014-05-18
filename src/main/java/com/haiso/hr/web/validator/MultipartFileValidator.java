package com.haiso.hr.web.validator;

import com.haiso.commons.exception.ContentTypeNotSupportException;
import com.haiso.commons.exception.FileOutOfMaxLengthException;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;

public class MultipartFileValidator extends HibernateValidator {
    private final static long MAX_SIZE = 1024 * 1024;

    /**
     * 文件大小上限
     */
    private long maxSize = MAX_SIZE;

    /**
     * 可接受的文件content-type
     */
    private String[] allowedContentTypes;

    @PostConstruct
    public void afterPropertiesSet() {
        Assert.notEmpty(allowedContentTypes, "The content types allowed to be uploaded must contain one at least!");
    }

    /**
     * 验证上传文件是否合法，如果不合法那么会抛出异常
     *
     * @param file 用户上传的文件封装类
     */
    public void validate(MultipartFile file) throws FileOutOfMaxLengthException, ContentTypeNotSupportException {
        Assert.notNull(file, "The multipart file is null!");
        if (file.getSize() > maxSize)
            throw new FileOutOfMaxLengthException("文件大小错误.", new Object[]{maxSize}, "上传的文件大小超过最大值!");
        if (!ArrayUtils.contains(allowedContentTypes, file.getContentType()))
            throw new ContentTypeNotSupportException("文件类型错误: ", file.getContentType(), "");
    }

    /**
     * 设置文件上传大小上限
     *
     * @param maxSize 文件上传大小上限
     */
    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 设置可接受的文件content-type数组
     *
     * @param allowedContentTypes 可接受的文件content-type数组
     */
    public void setAllowedContentTypes(String[] allowedContentTypes) {
        this.allowedContentTypes = allowedContentTypes;
    }
}