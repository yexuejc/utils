package com.yexue.gift.domain.pojo;

import com.yexuejc.util.base.pojo.BaseDO;

import java.util.Date;

/**
 * 流水记录DO
 *
 * @ClassName: FlowGiftDO
 * @Description:
 * @author: maxf
 * @date: 2018/2/11 10:22
 */
public class FlowGiftDO extends BaseDO {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String flowId;
    /**
     * 相关用户ID
     */
    private String consumerId;
    /**
     * 相关订单号
     */
    private String tradeNo;
    /**
     * 流水类型（固定为返利）
     */
    private String flowType;
    /**
     * 流水金额
     */
    private Integer amount;
    /**
     * 出入账钱包
     */
    private String wallet;
    /**
     * 出入账时间
     */
    private Date flowTime;
    /**
     * 交易完成后 该钱包的余额
     */
    private Integer balance;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public Date getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(Date flowTime) {
        this.flowTime = flowTime;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
