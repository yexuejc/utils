package com.yexue.gift.domain.pojo;

import com.yexuejc.util.base.pojo.BaseDO;

import java.util.Date;

/**
 * 小红包主表DO
 *
 * @ClassName: GiftDetailDO
 * @Description:
 * @author: maxf
 * @date: 2018/2/11 9:59
 */
public class GiftDetailDO extends BaseDO {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String giftDetailId;
    /**
     * 关联红包主表ID
     */
    private String giftId;
    /**
     * 小红包金额
     */
    private Integer money;
    /**
     * 抢到者ID
     */
    private String consumerId;
    /**
     * 抢到时间
     */
    private Date getTime;

    public String getGiftDetailId() {
        return giftDetailId;
    }

    public void setGiftDetailId(String giftDetailId) {
        this.giftDetailId = giftDetailId;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

}
