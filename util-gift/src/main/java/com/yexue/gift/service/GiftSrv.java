package com.yexue.gift.service;

import com.yexue.gift.domain.pojo.GiftDO;
import com.yexue.gift.domain.pojo.GiftDetailDO;
import com.yexue.gift.web.vo.GiftVO;
import com.yexuejc.util.base.pojo.ApiVO;
import com.yexuejc.util.base.pojo.PagerVO;

import java.util.List;
import java.util.Map;

/**
 * 红包相关
 * @PackageName: com.mcworle.ecentm.api.user.service
 * @Description:
 * @author: maxf
 * @date: 2018/2/5 10:47
 */
public interface GiftSrv {
    /**
     * 【抢】打开红包
     * @return
     * @param consumerId
     * @param giftDO
     */
    ApiVO open(String consumerId, GiftDO giftDO);

    /**
     * 红包列表
     * @param giftVO
     * @param consumerId
     * @return
     */
    List<Map> getList(GiftVO giftVO, String consumerId);

    /**
     * 红包总数
     * @param giftVO
     * @return
     */
    int getListCount(GiftVO giftVO);

    /**
     * 获取红包详情
     * @param id
     * @return
     */
    GiftDO getGift(String id);

    /**
     * 校验1
     * @param id
     * @return
     */
    boolean checkPromotionRank(String id);

    /**
     * 处理抢到的红包
     * @param giftId
     * @param consumerId
     * @return
     */
    boolean pullGift(String giftId, String consumerId);

    /**
     * 添加红包
     * @param giftVO
     * @param consumerId 发红包人id
     * @return
     */
    boolean addGift(GiftVO giftVO, String consumerId);

    /**
     * 一个大红包 已抢小红包列表
     * @param giftVO
     * @return
     */
    List<Map> getGiftDetails(GiftVO giftVO);

    /**
     * 一个大红包 已抢小红包总数
     * @param giftVO
     * @return
     */
    int getGiftDetailsCount(GiftVO giftVO);

    /**
     * 用户抢的红包【小红包】列表
     * @param consumerId
     * @param pagerVO
     * @return
     */
    List<GiftDetailDO> getMyGiftDetails(String consumerId, PagerVO pagerVO);

    /**
     * 用户抢的红包【小红包】总数
     * @param consumerId
     * @return
     */
    int getMyGiftDetailsCount(String consumerId);

    /**
     * 获取小红包详情
     * @param giftId
     * @param consumerId
     * @return
     */
    GiftDetailDO getGiftDetailByComsuner(String giftId, String consumerId);
}
