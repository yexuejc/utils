package com.yexuejc.util.base.pojo;

import com.yexuejc.util.base.util.JsonUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * DO基类
 */
public abstract class BaseDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 数据创建时间（精确到秒） */
    private Date crtTime;
    /** 数据创建者ID */
    private String crtBy;
    /** 数据最后一次修改时间（精确到秒） */
    private Date mdfyTime;
    /** 数据最后一次修改者ID */
    private String mdfyBy;

    @Override
    public String toString() {
        return JsonUtil.obj2Json(this);
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getCrtBy() {
        return crtBy;
    }

    public void setCrtBy(String crtBy) {
        this.crtBy = crtBy;
    }

    public Date getMdfyTime() {
        return mdfyTime;
    }

    public void setMdfyTime(Date mdfyTime) {
        this.mdfyTime = mdfyTime;
    }

    public String getMdfyBy() {
        return mdfyBy;
    }

    public void setMdfyBy(String mdfyBy) {
        this.mdfyBy = mdfyBy;
    }

}
