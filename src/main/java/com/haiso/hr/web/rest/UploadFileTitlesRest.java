package com.haiso.hr.web.rest;

import com.haiso.commons.model.excel.TitleCell;

import java.util.List;

/**
 * Created by Heli on 2014/5/16.
 */
public class UploadFileTitlesRest extends AbstractRest<List<TitleCell>>{
    public UploadFileTitlesRest(Boolean success, Integer code, String msg, List<TitleCell> content) {
        super(success, code, msg, content);
    }

    public UploadFileTitlesRest() {
    }
}
