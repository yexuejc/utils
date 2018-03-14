package com.yexue.gift.security;

import com.yexuejc.util.base.util.JsonUtil;

import java.io.Serializable;

/**
 *  用于存放授权后，需要提取的用户信息
 * @ClassName:  ConsumerToken   
 * @Description: 用于存放授权后，需要提取的用户信息
 * @author: maxf
 * @date:   2017年11月22日 下午4:39:29
 */
public class ConsumerToken implements Serializable {
    private static final long serialVersionUID = -1923797941L;

    /** 消费者用户名（手机号） */
    private String username;

    public ConsumerToken() {}

    public ConsumerToken(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return JsonUtil.obj2Json(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
