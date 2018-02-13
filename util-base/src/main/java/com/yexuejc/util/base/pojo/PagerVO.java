package com.yexuejc.util.base.pojo;

import com.yexuejc.util.base.util.JsonUtil;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PagerVO extends BaseVO {
    private static final long serialVersionUID = -7679296673189336136L;

    /**
     * 页码
     */
    @NotNull
    @Min(value = 1)
    private Integer page = 1;

    /**
     * 每页显示条数
     */
    @NotNull
    @Min(value = 1)
    private Integer size = 20;

    public int getOffset() {
        return (page - 1) * size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return JsonUtil.obj2Json(this);
    }
}
