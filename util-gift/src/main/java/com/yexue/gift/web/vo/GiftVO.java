package com.yexue.gift.web.vo;

import com.yexuejc.util.base.pojo.PagerVO;
import com.yexuejc.util.base.util.JsonUtil;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 红包
 *
 * @PackageName: com.mcworle.ecentm.api.user.web.vo
 * @Description:
 * @author: maxf
 * @date: 2018/2/5 14:39
 */
public class GiftVO extends PagerVO {
    /**
     * 大红包id
     */
    @NotBlank(groups = {Mdfy.class})
    private String giftId;

    /**
     * 小红包id
     */
    private String giftDetailId;

    /**
     * 金额
     */
    @NotNull(groups = {Add.class})
    @Min(value = 1, groups = {Add.class})
    private Integer money;
    /**
     * 个数
     */
    @NotNull(groups = {Add.class})
    @Min(value = 1, groups = {Add.class})
    private Integer num;
    /**
     * 条件
     */
    private List<String> condition;
    /**
     *红包名称
     */
    private String note;
    /**
     * 类型
     */
    @NotNull(groups = {Add.class})
    private String type;

    @Override
    public String toString() {
        return JsonUtil.obj2Json(this);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftDetailId() {
        return giftDetailId;
    }

    public void setGiftDetailId(String giftDetailId) {
        this.giftDetailId = giftDetailId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
