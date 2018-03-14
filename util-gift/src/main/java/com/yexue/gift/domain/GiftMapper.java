package com.yexue.gift.domain;

import com.yexue.gift.domain.pojo.FlowGiftDO;
import com.yexue.gift.domain.pojo.GiftDO;
import com.yexue.gift.domain.pojo.GiftDetailDO;
import com.yexue.gift.web.vo.GiftVO;
import com.yexuejc.util.base.pojo.PagerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 红包相关
 *
 * @PackageName: com.mcworle.ecentm.api.user.domain
 * @Description:
 * @author: maxf
 * @date: 2018/2/5 14:41
 */
@Mapper
public interface GiftMapper {
    /**
     * 红包总数
     *
     * @param giftVO
     * @return
     */
    Integer getListCount(GiftVO giftVO);

    /**
     * 红包列表
     *
     * @param giftVO
     * @return
     */
    List<GiftDO> getList(GiftVO giftVO);

    /**
     * 获取红包详情
     *
     * @param id
     * @return
     */
    GiftDO getGift(String id);

    /**
     * 获取小红包
     *
     * @param giftId
     * @return
     */
    GiftDetailDO getGiftDetail(@Param("giftId") String giftId);

    /**
     * 修改小红包
     *
     * @param giftDetailDO
     * @return
     */
    int updateGiftDateil(GiftDetailDO giftDetailDO);

    /**
     * 保存抢到红包的记录
     *
     * @param flowGiftDO
     * @return
     */
    int saveFlowGift(FlowGiftDO flowGiftDO);

    /**
     * 保存大红包
     *
     * @param giftDO
     * @return
     */
    int saveGift(GiftDO giftDO);

    /**
     * 保存小红包
     *
     * @param giftDetailDO
     * @return
     */
    int saveGiftDetail(GiftDetailDO giftDetailDO);


    /**
     * 一个大红包 已抢小红包列表
     *
     * @param giftVO
     * @return
     */
    List<Map> getGiftDetails(GiftVO giftVO);

    /**
     * 一个大红包 已抢小红包总数
     *
     * @param giftVO
     * @return
     */
    Integer getGiftDetailsCount(GiftVO giftVO);

    /**
     * 用户抢的红包【小红包】列表
     *
     * @param consumerId
     * @param pagerVO
     * @return
     */
    List<GiftDetailDO> getMyGiftDetails(@Param("consumerId") String consumerId, @Param("pager") PagerVO pagerVO);

    /**
     * 用户抢的红包【小红包】总数
     *
     * @param consumerId
     * @return
     */
    Integer getMyGiftDetailsCount(String consumerId);

    /**
     * 获取小红包详情
     * @param giftId
     * @param consumerId
     * @return
     */
    GiftDetailDO getGiftDetailByComsuner(@Param("giftId") String giftId, @Param("consumerId") String consumerId);
}
