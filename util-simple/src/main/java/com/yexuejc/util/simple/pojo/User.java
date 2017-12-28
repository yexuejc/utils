package com.yexuejc.util.simple.pojo;

import java.io.Serializable;

/**
 * 用户实例
 *
 * @PackageName: com.yexuejc.util.simple
 * @Description:
 * @author: maxf
 * @date: 2017/12/28 16:29
 */
public class User implements Serializable {

    /**
     * 用户id
     */
    private String id;
    /**
     * 手机、账号
     */
    private String mobile;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 别名
     */
    private String alias;
    /**
     * 简介
     */
    private String intro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pwd='" + pwd + '\'' +
                ", alias='" + alias + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
