package com.thinkcat.domain.base;

import lombok.Data;

/**
 * Created by Think Cat on 15/10/18.
 */
public class BasePage {
    private Integer offset;
    private Integer pageLength;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageLength() {
        return pageLength;
    }

    public void setPageLength(Integer pageLength) {
        this.pageLength = pageLength;
    }
}
