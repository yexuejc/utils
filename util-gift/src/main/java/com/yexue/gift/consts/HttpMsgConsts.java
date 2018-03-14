package com.yexue.gift.consts;

import com.yexuejc.util.base.constant.RespsConstant;

/**
 * <pre>
 * 网络请求统一返回 常量
 *
 * code使用:前缀+工程+模块+接口
 *
 * 1000：code前缀
 * 02  ：gift红包工程com.yexue.gift.*
 * 001  ：com.yexue.gift.web.GiftCtrl
 * </pre>
 *
 * @PackageName: com.yexue.gift.consts
 * @Description:
 * @author: maxf
 * @date: 2018/2/11 17:37
 */
public class HttpMsgConsts extends RespsConstant {

    /**
     * 红包不存在：100002001
     */
    public static final String RC_GIFT_NOT_FOUND = "100002001";
    public static final String RC_GIFT_NOT_FOUND_MSG = "红包不存在";
    /**
     * 开红包失败：100002002
     */
    public static final String RC_GIFT_OPEN_FAIL = "100002002";
    public static final String RC_GIFT_OPEN_FAIL_MSG = "您已抢过该红包";

    private HttpMsgConsts() {
        super();
    }
}
