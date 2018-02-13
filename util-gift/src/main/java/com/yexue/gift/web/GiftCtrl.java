package com.yexue.gift.web;

import com.yexue.gift.consts.HttpMsgConsts;
import com.yexue.gift.domain.pojo.GiftDO;
import com.yexue.gift.domain.pojo.GiftDetailDO;
import com.yexue.gift.security.ConsumerUser;
import com.yexue.gift.service.GiftSrv;
import com.yexue.gift.web.vo.GiftVO;
import com.yexuejc.util.base.constant.RespsConstant;
import com.yexuejc.util.base.http.Resps;
import com.yexuejc.util.base.util.DateUtil;
import com.yexuejc.util.base.util.ValidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 红包相关
 *
 * @PackageName: com.mcworle.ecentm.api.user.web
 * @Description:
 * @author: maxf
 * @date: 2018/2/5 10:25
 */
@RestController
@RequestMapping("/gift")
@Validated
public class GiftCtrl {

    @Autowired
    GiftSrv giftSrv;

    /**
     * 红包列表
     *
     * @param giftVO
     * @param errors
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/list")
    public Object list(@Validated GiftVO giftVO, Errors errors, HttpServletResponse response) throws IOException {
        if (errors.hasErrors()) {
            return ValidUtil.errResps(response, errors);
        }
        giftVO.setSize(10);
        ConsumerUser user = (ConsumerUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Map> list = giftSrv.getList(giftVO, user.getId());
        int count = giftSrv.getListCount(giftVO);
        Map<String, Object> map = new HashMap<>(2);
        map.put("list", list);
        map.put("count", count);
        return Resps.success(RespsConstant.MSG_SUCCESS_HTTP).setData(map);
    }

    /**
     * 打开红包
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/open/{id}", method = RequestMethod.GET)
    public Object open(@PathVariable String id, HttpServletResponse response) {
        ConsumerUser user = (ConsumerUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GiftDO giftDO = giftSrv.getGift(id);
        if (giftDO == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            Resps.fail(HttpMsgConsts.RC_GIFT_NOT_FOUND, HttpMsgConsts.RC_GIFT_NOT_FOUND_MSG);
        }
        GiftDetailDO giftDetailDO = giftSrv.getGiftDetailByComsuner(giftDO.getGiftId(), user.getId());
        if (giftDetailDO != null) {
            Resps resps = new Resps<>();
            Resps.fail(HttpMsgConsts.RC_GIFT_NOT_FOUND, HttpMsgConsts.RC_GIFT_NOT_FOUND_MSG)
                    .setData(giftDetailDO.getMoney());
            return resps;
        }
        if (giftDO.getStartTime().getTime() - System.currentTimeMillis() > 0) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return new Resps<>(RespsVO.RC_GIFT_NOT_FOUND, new String[]{
                    "红包 " + DateUtil.DATE_TIME_FORMAT.format(giftDO.getStartTime()) + " 开抢，请继续关注"});
        }
        if (giftDO.getEndTime().getTime() - System.currentTimeMillis() < 0) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return new Resps<>(RespsVO.RC_GIFT_NOT_FOUND, new String[]{RespsVO.RC_GIFT_NOT_FOUND_MSG5});
        }
        ApiVO apiVO = giftSrv.open(user.getId(), giftDO);

        if (apiVO.isFail()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return new Resps<>(apiVO.getCode(), apiVO.getMsgs());
        }
        Resps<Object> resps = new Resps<>();
        resps.setData(apiVO.getMsg());
        resps.setMsg(new String[]{"恭喜您，抢到" + MoneyUtil.toYuan(Integer.parseInt(apiVO.getMsg())) + "元红包，大吉大利！"});
        resps.setRc(NetConsts.RC_SUCCESS);
        return resps;
    }

    /**
     * 一个大红包那些人抢了
     *
     * @param giftVO
     * @param response
     * @return
     */
    @RequestMapping(value = "/detail/list", method = RequestMethod.POST)
    public Object getGiftDetails(@RequestBody @Validated(BaseVO.Mdfy.class) GiftVO giftVO, Errors errors,
                                 HttpServletResponse response) throws IOException {
        if (errors.hasErrors()) {
            return ValidUtil.errResps(response, errors);
        }
//        ConsumerUser user = (ConsumerUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        GiftDetailDO giftDetailDO = giftSrv.getGiftDetailByComsuner(giftVO.getGiftId(), user.getId());
//        if (giftDetailDO == null) {
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            return new Resps<>(RespsVO.RC_GIFT_NOT_FOUND, new String[]{RespsVO.RC_GIFT_NOT_FOUND_MSG7});
//        }
        List<Map> list = giftSrv.getGiftDetails(giftVO);
        int count = giftSrv.getGiftDetailsCount(giftVO);
        Map<String, Object> map = new HashMap<>(2);
        map.put("list", list);
        map.put("count", count);
        Resps<Object> resps = new Resps<>();
        resps.setData(map);
        resps.setRc(NetConsts.RC_SUCCESS);
        return resps;
    }

    /**
     * 我抢的红包
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/my/list", method = RequestMethod.POST)
    public Object getGiftDetails(PagerVO pagerVO, HttpServletResponse response) {
        ConsumerUser user = (ConsumerUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GiftDetailDO> list = giftSrv.getMyGiftDetails(user.getId(), pagerVO);
        int count = giftSrv.getMyGiftDetailsCount(user.getId());
        Map<String, Object> map = new HashMap<>(2);
        map.put("list", list);
        map.put("count", count);
        Resps<Object> resps = new Resps<>();
        resps.setData(map);
        resps.setRc(NetConsts.RC_SUCCESS);
        return resps;
    }

}
