package com.yexuejc.util.redis.web.vo;

import com.yexuejc.util.base.pojo.PagerVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 红包
 *
 * @PackageName: com.yexuejc.util.redis.web.vo
 * @Description:
 * @author: maxf
 * @date: 2018/2/6 10:24
 */
public class GiftVO extends PagerVO {
    /**
     * 金额
     */
    @NotNull
    @Min(1)
    private Integer money;
    /**
     * 个数
     */
    @NotNull
    @Min(1)
    private Integer num;
    /**
     * 条件
     */
    private String[] condition;
    /**
     * 类型
     */
    @NotNull
    private String type;

    @Override
    public String toString() {
        return super.toString();
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

    public String[] getCondition() {
        return condition;
    }

    public void setCondition(String[] condition) {
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
