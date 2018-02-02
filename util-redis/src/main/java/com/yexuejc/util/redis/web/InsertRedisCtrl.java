package com.yexuejc.util.redis.web;

import com.yexuejc.util.base.http.Resps;
import com.yexuejc.util.base.util.ValidUtil;
import com.yexuejc.util.redis.constant.RedisConst;
import com.yexuejc.util.redis.service.RedisSrv;
import com.yexuejc.util.redis.web.vo.InsertRedisVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 新增redis数据
 *
 * @PackageName: com.yexuejc.util.redis.web
 * @Description:
 * @author: maxf
 * @date: 2018/1/17 13:52
 */
@RestController
@RequestMapping("/insert")
public class InsertRedisCtrl {
    @Autowired
    @Qualifier("insertRedisSrvImpl")
    RedisSrv insertRedisSrv;

    /**
     * 添加登录用户信息
     *
     * @param insertRedisVO
     * @param errors
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/consumer-session", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public Object consumerSession(@RequestBody @Validated InsertRedisVO insertRedisVO,
                                  Errors errors,
                                  HttpServletResponse response) throws IOException {
        if (errors.hasErrors()) {
            return ValidUtil.errResps(response, errors);
        }
        insertRedisSrv.insertConsumerSession(insertRedisVO.setRedis(0, RedisConst.PREFIX_CONSUMER_SESSION));
        return Resps.success("添加成功");
    }
}
