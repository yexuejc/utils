package com.yexuejc.util.redis.web;

import com.yexuejc.util.base.util.JsonUtil;
import com.yexuejc.util.redis.service.RedisSrv;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.yexuejc.util.redis.web
 * @Description:
 * @author: maxf
 * @date: 2018/1/8 11:28
 */
@Api("redis 查询")
@RestController
@RequestMapping(method = RequestMethod.GET)
public class QueryRedisCtrl {
    @Autowired
    @Qualifier(value = "redisSrvImpl")
    RedisSrv redis1Srv;
    @Autowired
    @Qualifier(value = "redis0SrvImpl")
    RedisSrv redis0Srv;
    @Autowired
    @Qualifier(value = "redis5SrvImpl")
    RedisSrv redis5Srv;

    @ApiOperation("获取所有。0:登录用户信息库；1：短信库;5：红包")
    @RequestMapping("/list/all/{code}")
    public Object listAll(@PathVariable int code) {
        switch (code) {
            case 0:
                return JsonUtil.obj2Json(redis0Srv.getRedisAll());
            case 1:
                return JsonUtil.obj2Json(redis1Srv.getRedisAll());
            case 5:
                return JsonUtil.obj2Json(redis5Srv.getRedisAll());
            default:
                return null;
        }
    }

    /**
     * 后台登录用户信息
     *
     * @param mobile
     * @return
     */
    @ApiOperation("后台登录用户信息")
    @RequestMapping("/admin/{mobile}")
    public Object getRedis4Admin(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis0Srv.getRedis4Admin(mobile));
    }

    /**
     * 登录用户信息
     *
     * @param mobile
     * @return
     */
    @ApiOperation("APP登录用户信息")
    @RequestMapping("/consumer/{mobile}")
    public Object getRedis4Consumer(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis0Srv.getRedis4Consumer(mobile));
    }

    /**
     * 注册
     *
     * @param mobile
     * @return
     */
    @ApiOperation("注册发送的短信")
    @RequestMapping("/signup/{mobile}")
    public Object getRedis4Signup(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis1Srv.getRedis4signUp(mobile));
    }

    /**
     * 修改支付密码
     *
     * @param mobile
     * @return
     */
    @ApiOperation("修改支付密码发送的短信")
    @RequestMapping("/paypwd/{mobile}")
    public Object getRedis4PayPwd(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis1Srv.getRedis4PayPwd(mobile));
    }

    /**
     * 添加银行卡
     *
     * @param mobile
     * @return
     */
    @ApiOperation("添加银行卡发送的短信")
    @RequestMapping("/add-bank-card/{mobile}")
    public Object getRedis4AddBankCard(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis1Srv.getRedis4AddBankCard(mobile));
    }

    /**
     * 添加结算卡
     *
     * @param mobile
     * @return
     */
    @ApiOperation("添加结算卡发送的短信")
    @RequestMapping("/add-deposit-card/{mobile}")
    public Object getRedis4AddDepositCard(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis1Srv.getRedis4AddDepositCard(mobile));
    }

    /**
     * 自刷
     *
     * @param mobile
     * @return
     */
    @ApiOperation("自刷发送的短信")
    @RequestMapping("/cashout/{mobile}")
    public Object getRedis4Cashout(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis1Srv.getRedis4Cashout(mobile));
    }

    /**
     * 修改登录密码
     *
     * @param mobile
     * @return
     */
    @ApiOperation("修改登录密码发送的短信")
    @RequestMapping("/loginpwd/{mobile}")
    public Object getRedis4LoginPwd(@PathVariable String mobile) {
        return JsonUtil.obj2Json(redis1Srv.getRedis4LoginPwd(mobile));
    }

    /**
     * 获取一个红包id
     *
     * @return
     */
    @RequestMapping("/gift/{key}")
    public Object getGift(@PathVariable String key) {
        return redis5Srv.getGift(key);
    }
}
