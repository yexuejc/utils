package com.yexuejc.util.base.constant;

/**
 * <pre>
 * 网络请求统一返回 常量
 *
 * code使用:前缀+工程+模块+接口
 *
 * 1000：code前缀
 * 02  ：gift红包工程com.yexue.gift.*
 * </pre>
 *
 * @PackageName: com.yexuejc.util.base
 * @Description:
 * @author: maxf
 * @date: 2017/12/27 16:47
 */
public class RespsConstant {


    protected RespsConstant() {
    }

    /**
     * 成功:S
     */
    public static final String CODE_SUCCESS = "S";
    public static final String MSG_SUCCESS_HTTP = "请求成功";
    public static final String MSG_SUCCESS_OPERATE = "操作成功";
    /**
     * 失败:F
     */
    public static final String CODE_FAIL = "F";
    public static final String MSG_FAIL_HTTP = "请求失败";
    public static final String MSG_FAIL_OPERATE = "操作失败";
    /**
     * 错误:E
     */
    public static final String CODE_ERROR = "E";
    public static final String MSG_ERROT_HTTP = "请求错误";
    public static final String MSG_ERROT_OPERATE = "操作错误";

    /**
     * 参数校验错误:V
     */
    public static final String CODE_VALIDATION = "V";
    public static final String MSG_VALIDATION = "参数错误";
}
