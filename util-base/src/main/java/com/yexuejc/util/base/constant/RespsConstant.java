package com.yexuejc.util.base.constant;

/**
 * 网络请求统一返回 常量
 *
 * @PackageName: com.yexuejc.util.base
 * @Description:
 * @author: maxf
 * @date: 2017/12/27 16:47
 */
public class RespsConstant {

    private RespsConstant() {
    }

    /**
     * 成功
     */
    public static final String CODE_SUCCESS = "S";
    public static final String MSG_SUCCESS_HTTP = "请求成功";
    public static final String MSG_SUCCESS_OPERATE = "操作成功";
    /**
     * 失败
     */
    public static final String CODE_FAIL = "F";
    public static final String MSG_FAIL_HTTP = "请求失败";
    public static final String MSG_FAIL_OPERATE = "操作失败";
    /**
     * 错误
     */
    public static final String CODE_ERROR = "E";
    public static final String MSG_ERROT_HTTP = "请求错误";
    public static final String MSG_ERROT_OPERATE = "操作错误";
}
