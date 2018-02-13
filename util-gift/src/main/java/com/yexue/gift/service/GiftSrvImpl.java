package com.yexue.gift.service;

import com.yexue.gift.consts.ConsumerConsts;
import com.yexue.gift.consts.GiftConst;
import com.yexue.gift.domain.GiftMapper;
import com.yexue.gift.domain.pojo.ConsumerDO;
import com.yexue.gift.domain.pojo.GiftDO;
import com.yexuejc.util.base.autoconfigure.MutiRedisAutoConfiguration;
import com.yexuejc.util.base.pojo.ApiVO;
import com.yexuejc.util.base.util.JsonUtil;
import com.yexuejc.util.base.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 红包相关
 *
 * @PackageName: com.mcworle.ecentm.api.user.service
 * @Description:
 * @author: maxf
 * @date: 2018/2/5 10:47
 */
@Service
public class GiftSrvImpl extends BaseSrvImpl implements GiftSrv {
    public static final String PREFIX_GIFT_SESSION = "gift";

    @Autowired
    GiftMapper giftMapper;

    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE5)
    RedisTemplate<Object, Object> redisTemplate5;


    /**
     * 【抢】打开红包
     *
     * @param consumerId
     * @param giftDO
     * @return
     */
    @Override
    public ApiVO open(String consumerId, GiftDO giftDO) {
        ApiVO apiVO = new ApiVO();
        ConsumerDO consumerDO = accountMapper.getConsumerById(consumerId);
        Map<String, Object> tmap = accountMapper.checkConsumer(consumerId);
        ApiVO checkApi = checkGiftType(consumerDO, giftDO, tmap);
        if (checkApi.isFail()) {
            return checkApi;
        }
        //拿到1个红包 格式：gift = giftId-money
        String gift = (String) redisTemplate5.opsForList().leftPop(PREFIX_GIFT_SESSION + "-" + giftDO.getGiftId());
        if (StrUtil.isEmpty(gift)) {
            apiVO.setStatus(ApiVO.STATUS.F, RespsVO.RC_GIFT_NOT_FOUND2, RespsVO.RC_GIFT_NOT_FOUND_MSG);
            return apiVO;
        }
        String[] gifts = gift.split("-");
        String giftId = gifts[0];
        String money = gifts[1];
        Map<String, String> map = new HashMap<>(2);
        map.put("giftId", giftId);
        map.put("consumerId", consumerId);
        mnsFacade.sendMsg(MqConst.MQ_GIFT, JsonUtil.obj2Json(map), 0);

        apiVO.setStatus(ApiVO.STATUS.S);
        apiVO.setMsg(money);
        return apiVO;
    }

    /**
     * 判断是否可抢
     *
     * @param consumerDO
     * @param giftDO
     * @param map
     * @return
     */
    private ApiVO checkGiftType(ConsumerDO consumerDO, GiftDO giftDO, Map<String, Object> map) {
        ApiVO apiVO = new ApiVO();
        boolean b = false;
        if (giftDO.getCondition() != null) {
            for (String str : giftDO.getCondition()) {
                switch (str) {
                    case GiftConst.CONDITION_A:
                        if (ConsumerConsts.CONSUMER_LEVEL_A.equals(consumerDO.getConsumerLevel())) {
                            b = true;
                        }
                        break;
                    case GiftConst.CONDITION_B:
                        if (ConsumerConsts.CONSUMER_LEVEL_B.compareTo(consumerDO.getConsumerLevel()) >= 0) {
                            b = true;
                        }
                        break;
                    case GiftConst.CONDITION_C:
                        if (ConsumerConsts.CONSUMER_LEVEL_C.compareTo(consumerDO.getConsumerLevel()) >= 0) {
                            b = true;
                        }
                        break;
                    case GiftConst.CONDITION_D:
                        if (ConsumerConsts.CONSUMER_LEVEL_D.compareTo(consumerDO.getConsumerLevel()) >= 0) {
                            b = true;
                        }
                        break;
                    case GiftConst.CONDITION_ACTIVE:
                        if (!Boolean.valueOf(String.valueOf(map.get("is_active")))) {
                            apiVO.setStatus(ApiVO.STATUS.F, RespsVO.RC_GIFT_NOT_FOUND, RespsVO.RC_GIFT_NOT_FOUND_MSG8);
                            return apiVO;
                        }
                        break;
                    case GiftConst.CONDITION_REAL:
                        if (!Boolean.valueOf(String.valueOf(map.get("is_real")))) {
                            apiVO.setStatus(ApiVO.STATUS.F, RespsVO.RC_GIFT_NOT_FOUND, RespsVO.RC_GIFT_NOT_FOUND_MSG9);
                            return apiVO;
                        }
                        break;
                    case GiftConst.CONDITION_CASH:
                        if (!Boolean.valueOf(String.valueOf(map.get("is_cash")))) {
                            apiVO.setStatus(ApiVO.STATUS.F, RespsVO.RC_GIFT_NOT_FOUND, RespsVO.RC_GIFT_NOT_FOUND_MSG10);
                            return apiVO;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if (!b) {
            apiVO.setStatus(ApiVO.STATUS.F, RespsVO.RC_GIFT_NOT_FOUND, RespsVO.RC_GIFT_NOT_FOUND_MSG11);
            return apiVO;
        }
        if (GiftConst.TYPE_5W.equals(giftDO.getGiftType())) {
            PromotionRankDO promotionRankDO = walletMapper.getPromotionRankByConsumerId(consumerDO.getConsumerId());
            if (promotionRankDO == null) {
                apiVO.setStatus(ApiVO.STATUS.F, RespsVO.RC_GIFT_NOT_FOUND, RespsVO.RC_GIFT_NOT_FOUND_MSG12);
                return apiVO;
            }
        }
        apiVO.setStatus(ApiVO.STATUS.S);
        return apiVO;
    }

    /**
     * 红包列表
     *
     * @param giftVO
     * @param consumerId
     * @return
     */
    @Override
    public List<Map> getList(GiftVO giftVO, String consumerId) {
        List<GiftDO> list = giftMapper.getList(giftVO);
        List<Map> list1 = new ArrayList<>();
        for (GiftDO giftDO : list) {
            Map<String, Object> map = new HashMap<>();
            ConsumerDO consumerDO = accountMapper.getConsumerById(consumerId);
            Map<String, Object> tmap = accountMapper.checkConsumer(consumerId);
            map.putAll(JsonUtil.json2Obj(JsonUtil.obj2Json(giftDO), Map.class));
            ApiVO checkApi = checkGiftType(consumerDO, giftDO, tmap);
            map.put("open", checkApi.isSucc());
            map.put("msg", checkApi.getMsg());
            list1.add(map);
        }
        return list1;
    }

    /**
     * 红包总数
     *
     * @param giftVO
     * @return
     */
    @Override
    public int getListCount(GiftVO giftVO) {
        Integer integer = giftMapper.getListCount(giftVO);
        return integer == null ? 0 : integer;
    }

    /**
     * 获取红包详情
     *
     * @param id
     * @return
     */
    @Override
    public GiftDO getGift(String id) {
        return giftMapper.getGift(id);
    }

    /**
     * 校验是否满5w
     *
     * @param consumerId
     * @return
     */
    @Override
    public boolean checkPromotionRank(String consumerId) {
        PromotionRankDO promotionRankDO = walletMapper.getPromotionRankByConsumerId(consumerId);
        if (promotionRankDO != null) {
            return true;
        }
        return false;
    }

    /**
     * 处理抢到的红包
     *
     * @param giftId
     * @param consumerId
     * @return
     */
    @Override
    public boolean pullGift(String giftId, String consumerId) {
        GiftDetailDO giftDetailDO = giftMapper.getGiftDetail(giftId);
        if (giftDetailDO == null) {
            LogUtil.bizLogger.error("抢到红包详情查询失败：小红包id:{}", giftId);
            return false;
        }
        if (giftDetailDO.getConsumerId() != null) {
            LogUtil.bizLogger.error("抢到的红包已有归属：小红包id:{}，归属人：{}，抢包人：{}",
                    giftId, giftDetailDO.getConsumerId(), consumerId);
            return false;
        }
        giftDetailDO.setConsumerId(consumerId);
        int result = giftMapper.updateGiftDateil(giftDetailDO);
        if (result < 1) {
            LogUtil.bizLogger.error("抢到红包详情修改失败：小红包id:{}", giftId);
        }
        result = profitMapper.cashProfit(consumerId, giftDetailDO.getMoney());
        if (result < 1) {
            LogUtil.bizLogger.error("抢到红包给用户加钱失败：小红包id:{}", giftId);
        }
        WalletDO walletDO = walletMapper.getWalletByConsumerId(consumerId);
        FlowGiftDO flowGiftDO = new FlowGiftDO();
        flowGiftDO.setFlowId(StrUtil.genUUID());
        flowGiftDO.setConsumerId(consumerId);
        flowGiftDO.setAmount(giftDetailDO.getMoney());
        flowGiftDO.setTradeNo(giftDetailDO.getGiftDetailId());
        flowGiftDO.setFlowType(TradeConst.TRADETYPE_GIFT);
        flowGiftDO.setWallet(WalletConst.WALLET_CASH);
        flowGiftDO.setBalance(walletDO.getCash());
        result = giftMapper.saveFlowGift(flowGiftDO);
        if (result < 1) {
            LogUtil.bizLogger.error("抢到红包写记录：小红包id:{}", giftId);
        }
        return true;
    }

    /**
     * 添加红包
     *
     * @param giftVO
     * @param consumerId 发红包人id
     * @return
     */
    @Override
    public boolean addGift(GiftVO giftVO, String consumerId) {
        //用户减钱
        //S账户余额变更
        Integer result = profitMapper.cashProfit(SysConsts.S_ID, -giftVO.getMoney());
        if (result == null || result < 0) {
            LogUtil.bizLogger.error("发红包失败:用户减钱失败");
            return false;
        }
        GiftDO giftDO = new GiftDO();
        giftDO.setGiftId(StrUtil.genUUID());
        giftDO.setMoney(giftVO.getMoney());
        giftDO.setCondition(giftVO.getCondition());
        giftDO.setNum(giftVO.getNum());
        giftDO.setGiftType(giftVO.getType());
        giftDO.setStartTime(new Date());
        giftDO.setNote(giftVO.getNote());
        giftDO.setEndTime(DateUtil.localDateTime2Date(LocalDateTime.now().minusDays(-1)));
        int i = giftMapper.saveGift(giftDO);
        if (i < 1) {
            LogUtil.bizLogger.error("保存大红包失败:{}", giftDO.toString());
            return false;
        }
        List<Integer> list = GIftUtil.splitRedPackets(giftDO.getMoney(), giftDO.getNum());
        List<String> redisList = new ArrayList<>();
        //拆成小红包
        for (int money : list) {
            GiftDetailDO giftDetailDO = new GiftDetailDO();
            giftDetailDO.setGiftId(giftDO.getGiftId());
            giftDetailDO.setGiftDetailId(StrUtil.genUUID());
            giftDetailDO.setMoney(money);
            i = giftMapper.saveGiftDetail(giftDetailDO);
            if (i < 1) {
                LogUtil.bizLogger.error("保存小红包失败:大红包id：{}，小红包id:{}",
                        giftDO.getGiftId(), giftDetailDO.getGiftDetailId());
                return false;
            }
            redisList.add(giftDetailDO.getGiftDetailId() + "-" + giftDetailDO.getMoney());
        }
        //存redis
        redisTemplate5.afterPropertiesSet();
        redisTemplate5.opsForList().rightPushAll(
                PREFIX_GIFT_SESSION + "-" + giftDO.getGiftId(),
                JsonUtil.json2Obj(JsonUtil.obj2Json(redisList), List.class));
        return true;
    }

    /**
     * 一个大红包 已抢小红包列表
     *
     * @param giftVO
     * @return
     */
    @Override
    public List<Map> getGiftDetails(GiftVO giftVO) {
        return giftMapper.getGiftDetails(giftVO);
    }

    /**
     * 一个大红包 已抢小红包总数
     *
     * @param giftVO
     * @return
     */
    @Override
    public int getGiftDetailsCount(GiftVO giftVO) {
        Integer integer = giftMapper.getGiftDetailsCount(giftVO);
        return integer == null ? 0 : integer;
    }

    /**
     * 用户抢的红包【小红包】列表
     *
     * @param consumerId
     * @param pagerVO
     * @return
     */
    @Override
    public List<GiftDetailDO> getMyGiftDetails(String consumerId, PagerVO pagerVO) {
        return giftMapper.getMyGiftDetails(consumerId, pagerVO);
    }

    /**
     * 用户抢的红包【小红包】总数
     *
     * @param consumerId
     * @return
     */
    @Override
    public int getMyGiftDetailsCount(String consumerId) {
        Integer integer = giftMapper.getMyGiftDetailsCount(consumerId);
        return integer == null ? 0 : integer;
    }

    @Override
    public GiftDetailDO getGiftDetailByComsuner(String giftId, String consumerId) {
        return giftMapper.getGiftDetailByComsuner(giftId, consumerId);
    }
}
