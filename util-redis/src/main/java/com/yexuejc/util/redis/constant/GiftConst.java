package com.yexuejc.util.redis.constant;

/**
 * 红包相关常量
 *
 * @PackageName: com.mcworle.ecentm.api.user.constant
 * @Description:
 * @author: maxf
 * @date: 2018/2/5 15:38
 */
public class GiftConst {
    private GiftConst() {
    }

    /**
     * 红包类型：普通红包
     */
    public static final String TYPE_A = "A";
    /**
     * 红包类型：5w活动红包
     */
    public static final String TYPE_B = "B";

    /**
     * 红包条件：A [A等级 可抢]
     */
    public static final String CONDITION_A = "A";
    /**
     * 红包条件：B [B等级及以上 可抢]
     */
    public static final String CONDITION_B = "B";
    /**
     * 红包条件：C [C等级及以上 可抢]
     */
    public static final String CONDITION_C = "C";
    /**
     * 红包条件：D [D等级及以上 可抢]
     */
    public static final String CONDITION_D = "D";
    /**
     * 红包条件：active [激活 可抢]
     */
    public static final String CONDITION_ACTIVE = "active";
    /**
     * 红包条件：real [实名 可抢]
     */
    public static final String CONDITION_REAL = "real";
    /**
     *红包条件：cash [达标 可抢]
     */
    public static final String CONDITION_CASH = "cash";
}
