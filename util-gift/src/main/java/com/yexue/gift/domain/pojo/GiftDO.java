package com.yexue.gift.domain.pojo;

import com.yexuejc.util.base.pojo.BaseDO;

import java.util.Date;
import java.util.List;

/**
 * 红包主表DO
 * @ClassName: GiftDO
 * @Description:
 * @author: maxf
 * @date: 2018/2/11 9:58
 */
public class GiftDO extends BaseDO {
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String giftId;
    /** 红包类型 */
    private String giftType;
    /** 红包总金额 */
    private Integer money;
    /** 拆分红包个数 */
    private Integer num;
    /** 抢红包条件 */
    private List<String> condition;
    /** 开抢时间 */
    private Date startTime;
    /** 结束时间 */
    private Date endTime;
    /** 红包描述 */
    private String note;

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<String> getCondition() {
        return condition;
    }

    public void setCondition(List<String> condition) {
        this.condition = condition;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
