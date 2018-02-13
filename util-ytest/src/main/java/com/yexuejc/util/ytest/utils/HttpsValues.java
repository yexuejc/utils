package com.yexuejc.util.ytest.utils;

/**
 * @author maxf
 * @version 1.0
 * @name hexi
 * @explain 网络请求路径
 * @time 2017/2/2115:25
 */

public class HttpsValues {

    /**
     * 前缀
     */
    public final static String SERVER_URL_PREFIX = "https://common.globalhexi.cn:443/common";// common
    public final static String SERVER_URL_PREFIX_SHOP = "https://shop.globalhexi.cn:443/shop";// shop
    public final static String SERVER_URL_PREFIX_NEWS = "https://news.globalhexi.cn/news";// news
    public final static String SERVER_URL_PREFIX_GIFT = "https://gift.globalhexi.cn/gift";// gift
    public final static String SERVER_URL_PREFIX_ZC = "https://crowdfunding.globalhexi.cn/crowdfunding";// crowdfunding
    public final static String SERVER_URL_PREFIX_QGJ = "https://secondskill.globalhexi.cn/secondskill";// secondskill
    public final static String SERVER_URL_PREFIX_HB = "https://integral.globalhexi.cn/integral";// HB
    public final static String SERVER_URL_ASSISTANT = "https://assistant.globalhexi.cn/assistant";// assistant
    public final static String SERVER_URL_INTEGRAL = "https://integral.globalhexi.cn/integral";// integral


    /**
     * 加载图片地址前缀
     */
    public final static String URL_LOAD_IMAGE = "http://image.globalhexi.com/";

    /**
     * NO1、和系登录
     */
    public final static String URL_HX_LOGIN = SERVER_URL_PREFIX + "/member/login";

    /**
     * NO2、请求指定图标
     */
    public final static String GET_PING_GO_PPT = SERVER_URL_PREFIX_SHOP + "/pptIco/list";

    /**
     * NO3、给没有注册的手机号发送验证码
     */
    public final static String URL_SEND_MOBILE_VALIDATION_CODE_SS = SERVER_URL_PREFIX + "/member/sendsmsNoreg";

    /**
     * NO4、校验验证码
     */
    public final static String URL_MOBILE_VALIDATION_CODE = SERVER_URL_PREFIX + "/member/verifySms";

    /**
     * NO5
     */
    public final static String URL_SETTING_USER_MOBILE = SERVER_URL_PREFIX + "/member/mobileByMemberId";

    /**
     * NO6、获取首页图片地址
     */
    public final static String GET_IMAGE_URLD = SERVER_URL_PREFIX_SHOP + "/pptIco/listAll";

    /**
     * NO7、获取线上商品列表
     */
    public final static String URL_UP_PRODUCT_LIST = SERVER_URL_PREFIX_SHOP + "/goods/upGoods";

    /**
     * NO8、获取淘宝首页商品列表
     */
    public final static String GET_TBK_LIST_MAIN = SERVER_URL_PREFIX + "/taobaoke/taoBaoKuSubject";

    /***
     * NO9、获取抢购时间段时间戳
     */
    public final static String URL_GET_QGJ_NOW_TIMESSSS = SERVER_URL_PREFIX_QGJ + "/secondskill/serverTime";
    /**
     * NO10、获取和系头条列表
     */
    public final static String URL_GET_HETT_LIST = SERVER_URL_PREFIX_NEWS + "/news/newsList";

    /**
     * NO11、 获取推荐店铺
     */
    public final static String GET_HOT_STORES = SERVER_URL_PREFIX_SHOP + "/goods/goodShops";
    /**
     * NO12、 手机号快捷登录(短信验证码)
     */
    public final static String URL_GET_PHONE_CODE_FOR_LOGIN = SERVER_URL_PREFIX + "/member/getCodeForLogin";
    /**
     * NO13、 QQ登录
     */
    public final static String URL_QQ_LOGIN = SERVER_URL_PREFIX + "/member/qqLoginTwo";
    /**
     * NO14.短信快捷登录
     */
    public final static String URL_GET_LOGIN_SMS = SERVER_URL_PREFIX + "/member/loginBySms";
    /**
     * NO15、获取图片验证码
     */
    public final static String URL_GET_IMAGE_CODE = SERVER_URL_PREFIX + "/verify/req/200/100/200";
    /**
     * NO16、ID获取用户基本信息
     */
    public final static String URL_GET_USER_INFO = SERVER_URL_PREFIX + "/member/member";
    /**
     * NO17、获取订单数量
     */
    public final static String URL_GET_ORDER_NUMBERS = SERVER_URL_PREFIX_SHOP + "/order/initOrderCount";
    /**
     * NO18、查询用户是否设置登录及支付密码
     */
    public final static String URL_GET_IS_PWD = SERVER_URL_PREFIX + "/member/queryUserLppwd";
    /**
     * NO19、获取大分类分类列表
     */
    public final static String URL_GET_CLASSES = SERVER_URL_PREFIX_SHOP + "/goods/goodsCategorylist";
    /**
     * NO20、获取大分类商品列表
     */
    public final static String URL_GET_MAX_CLASS_PRODUCT_LIST = SERVER_URL_PREFIX_SHOP + "/goods/goodsCateList";
    /**
     * NO21、获取购物车列表
     */
    public final static String URL_GET_CAR_LIST = SERVER_URL_PREFIX_SHOP + "/cart_item/list";
    /**
     * NO21、获取推荐商品
     */
    public final static String TUIJIAN_GOODS_LIST_URL = SERVER_URL_PREFIX_SHOP + "/goods/tuijianGoods";
    /**
     * NO22、获取购物车列表加
     */
    public final static String URL_GET_CAR_LIST_JIA = SERVER_URL_PREFIX_SHOP + "/cart_item/jia";
    /**
     * NO23、获取购物车列表减
     */
    public final static String URL_GET_CAR_LIST_JIAN = SERVER_URL_PREFIX_SHOP + "/cart_item/jian";
    /**
     * NO24、删除购物车商品
     */
    public final static String URL_GET_CAR_LIST_DELETE = SERVER_URL_PREFIX_SHOP + "/cart_item/deleteCart";
    /**
     * NO25、获取城市或地区编号
     */
    public final static String COUNTRIES_REGIONS = "http://app.globalhexi.com/transfer/upload/js/countries_regions.json";
    /**
     * NO26、检查手机号码是否被注册
     */
    public final static String URL_CHECK_MOBILE_IS_REGISTER = SERVER_URL_PREFIX + "/member/checkMobileOrRecommenderMobile";
    /**
     * NO27、校验图形验证码
     */
    public final static String URL_CHEACK_IMAGE_CODE = SERVER_URL_PREFIX + "/verify/ver";
    /**
     * NO28、注册第一步(短信验证码)
     */
    public final static String URL_GET_PHONE_CODE = SERVER_URL_PREFIX + "/member/registerCode";

    /**
     * NO29、注册第二步(添加注册信息)
     */
    public final static String URL_REGISTER = SERVER_URL_PREFIX + "/member/register";
    /**
     * NO30、微博登录
     */
    public final static String URL_WB_LOGIN = SERVER_URL_PREFIX + "//member/weiboLoginTwo";

    /**
     * NO31、手机验证码
     */
    public final static String URL_SEND_MOBILE_VALIDATION_CODE = SERVER_URL_PREFIX + "/member/sendSms";
    /**
     * NO31、第三方登录，直接绑定手机号
     */
    public final static String URL_GET_BIND_MOBILE = SERVER_URL_PREFIX + "/member/bindMobile";
    /**
     * NO32、微信登录
     */
    public final static String URL_WX_LOGIN = SERVER_URL_PREFIX + "/member/weixinLoginTwo";
    /**
     * NO33、提交用户登录时间
     */
    public final static String URL_JPUSH_LOGIN_TIME = SERVER_URL_PREFIX + "/member/updateMemberLastOperate";
    /**
     * NO34、微信绑定
     */
    public final static String URL_BIND_WX = SERVER_URL_PREFIX + "/member/bindWeixin";
    /**
     * NO35、短信找回登录密码
     */
    public final static String URL_GET_LOGIN_PWD_WITH_MESSAGE = SERVER_URL_PREFIX + "/member/retrievePassword";
    /**
     * NO36、上传图片
     */
    public final static String URL_UP_IMAGE = SERVER_URL_PREFIX + "/upload/updateImgs";
    /**
     * NO37、提交申述
     */
    public final static String SEND_APPLY = SERVER_URL_PREFIX + "/member/memberShenShu";
    /**
     * NO38、更新用户名
     */
    public final static String URL_UPDATE_USER_NAME = SERVER_URL_PREFIX + "/member/update";
    /**
     * NO39、更新用户头像
     */
    public final static String URL_UPDATE_USER_HEAD = SERVER_URL_PREFIX + "/member/updateHeade";
    /**
     * NO40、修改登录密码
     */
    public final static String URL_UPDATE_LOGIN_PWD = SERVER_URL_PREFIX + "/member/updatePwd";
    /**
     * NO41、查询用户是否设置登录及支付密码
     */
    public final static String URL_CHECK_SET_PWD = SERVER_URL_PREFIX + "/member/queryUserLppwd";
    /**
     * NO42、修改支付密码
     */
    public final static String URL_UPDATE_PAY_PWD = SERVER_URL_PREFIX + "/member/updateHebiPwd";
    /**
     * NO43、支付密码，直接设置支付密码
     */
    public final static String URL_SET_PAY_PWD = SERVER_URL_PREFIX + "/member/setHebiPwd";
    /**
     * NO44、短信找回支付密码
     */
    public final static String URL_GET_PAY_PWD_WITH_MESSAGE = SERVER_URL_PREFIX + "/member/retrievePayPassword";
    /**
     * NO45、获取下线数量
     */
    public final static String GET_DOWN_LINE_COUNT = SERVER_URL_PREFIX + "/member/downLineListCount";
    /**
     * NO46、获取和粉列表
     */
    public final static String GET_HEFEN_LIST = SERVER_URL_PREFIX + "/member/downLineList";
    /**
     * NO47、获取手册
     */
    public final static String GET_NOTE_BOOK = SERVER_URL_PREFIX_SHOP + "/help/noteBook";
    /**
     * NO48、推送给和粉，叫他们去邀请好友
     */
    public final static String J_PUSHS = SERVER_URL_PREFIX + "/messagePush/pushInvitationMsg";
    /**
     * NO49、按月份 分页获取 余额使用记录
     */
    public final static String GET_SOURCE_RECORD_LIST = SERVER_URL_PREFIX + "/member/sourceRecordList";
    public final static String GET_SOURCE_RECORD_LIST2 = SERVER_URL_PREFIX + "/member/sourceRecordListn";
    /**
     * NO50、获取极品商品列表
     */
    public final static String URL_JP_PRODUCT_LIST = SERVER_URL_PREFIX_SHOP + "/goods/JiPingGoodsList";
    /**
     * NO51、获取线上商品列表
     */
    public final static String URL_GET_THEM_PRODUCTS = SERVER_URL_PREFIX_SHOP + "/goods/subjList";
    /**
     * NO52、获取会员绑定信息
     */
    public final static String URL_GET_BIND_INFO = SERVER_URL_PREFIX + "/member/bindList";
    /**
     * NO53、微博绑定
     */
    public final static String URL_BIND_WB = SERVER_URL_PREFIX + "/member/bindWeibo";
    /**
     * NO54、QQ绑定
     */
    public final static String URL_BIND_QQ = SERVER_URL_PREFIX + "/member/bindQQ";
    /**
     * NO55、检查支付密码
     */
    public final static String URL_CHECK_PAY_PASSWORD = SERVER_URL_PREFIX + "/member/checkPayPassword";
    /**
     * NO56、转账
     */
    public final static String PRESENT_HEBI = SERVER_URL_PREFIX + "/member/presentHebi";
    /**
     * NO57、转账列表
     */
    public final static String TRANSFER_ACCOUNTS_RECORDLIST = SERVER_URL_PREFIX + "/member/transferAccountsRecordList";
    /**
     * NO58、获取收藏的店铺IDS
     */
    public final static String COLLECTION_BUSBASE_LIST = SERVER_URL_PREFIX_SHOP + "/favorite/collectionBusbaseList";
    /**
     * NO59、获取收藏的商品IDS
     */
    public final static String COLLECTION_GOODS_LIST = SERVER_URL_PREFIX_SHOP + "/favorite/collectionGoodsList";
    /**
     * NO60、收藏/取消收藏 商品
     */
    public final static String COLLECTION_GOODS = SERVER_URL_PREFIX_SHOP + "/favorite/collectionGoods";
    /**
     * NO61、收藏/取消收藏 店铺
     */
    public final static String COLLECTION_BUSBASE = SERVER_URL_PREFIX_SHOP + "/favorite/collectionBusbase";
    /**
     * NO62、根据类型获取问题列表
     */
    public final static String GET_HEXITYPE_BY_NAME = SERVER_URL_PREFIX + "/member/heXitypeByName";
    /**
     * NO63、提交反馈
     */
    public final static String SEND_MESSAGE_FOR_ME = SERVER_URL_PREFIX + "/member/addCustomerService";
    /**
     * NO64、商户入驻：检查商户名称是否存在
     */
    public final static String JUDGE_SHOP_NAME = SERVER_URL_ASSISTANT + "/busbase/judgeShopName";
    /**
     * NO65、商户入驻
     */
    public final static String BUSBASE_ENTER_NEW = SERVER_URL_ASSISTANT + "/busbase/busbaseEnter";
    /**
     * NO67、淘特价分类
     */
    public final static String GET_TTJ_CLASS = SERVER_URL_PREFIX + "/taobaoke/getTaoKuTwo";
    /**
     * NO68、获取淘宝商品列表
     */
    public final static String GET_TBK_LIST = SERVER_URL_PREFIX + "/taobaoke/taoBaoKuGoodsList";
    /**
     * NO69、获取和系头条详情
     */
    public final static String URL_GET_HETT_DETAIL = SERVER_URL_PREFIX_NEWS + "/news/news";
    /**
     * NO70、获取和系头条详情评论list
     */
    public final static String URL_GET_HETT_DETAIL_PL_LIST = SERVER_URL_PREFIX_NEWS + "/news/newsCommentPagingation";
    /**
     * NO71、评论头条
     */
    public final static String URL_PL_TT = SERVER_URL_PREFIX_NEWS + "/news/addNewsCommentByNewsId";
    /**
     * NO72、回复别人回复
     */
    public final static String URL_CLICK_HF = SERVER_URL_PREFIX_NEWS + "/news/addNewsCommentByNewsCommentId";
    /**
     * NO73、 获取线上单个商品详情
     */
    public final static String URL_GET_ONE_PRODUCT_DETAIL = SERVER_URL_PREFIX_SHOP + "/goods/goods";
    /**
     * NO74、获取当前商品评论数量
     */
    public final static String URL_GET_PRODUCT_PL_ONE = SERVER_URL_PREFIX_SHOP + "/commentary/commentaryList";
    /**
     * NO75、获取商户的商品列表
     */
    public final static String GAT_BUS_GOODS_LIST_BY_ID = SERVER_URL_PREFIX_SHOP + "/goods/upGoodsByBasebaseId";
    /**
     * NO76、获取收获地址列表
     */
    public final static String URL_GET_MEMBER_ADDRESSES = SERVER_URL_PREFIX + "/receiver/list";
    /**
     * NO77、添加购物车
     */
    public final static String URL_ADD_TO_CAR = SERVER_URL_PREFIX_SHOP + "/cart_item/add";
    /**
     * NO78、获取支付方式
     */
    public final static String GET_PAY_TYPE = SERVER_URL_PREFIX_SHOP + "/pay/paymentConfigQy";
    /**
     * NO79、加载单个商户商品
     */
    public final static String INDENT_LOADGOODS = SERVER_URL_PREFIX_SHOP + "/goods/loadGoods";
    /**
     * 计算该笔交易可以使用多少红包币 使用价格
     */
    public final static String ACCOUNTED_GIFT_AMOUNT_BY_PRICE = SERVER_URL_PREFIX + "/member/accountedGiftAmountByPrice";
    /**
     * NO81、设置会员默认地址
     */
    public final static String URL_SET_DEFAULT_ADDRESSES = SERVER_URL_PREFIX + "/receiver/settingDefault";
    /**
     * NO82、删除单个收获地址列表
     */
    public final static String URL_DELET_MEMBER_ADDRESS = SERVER_URL_PREFIX + "/receiver/delete";
    /**
     * NO83、获取单个收获地址列表
     */
    public final static String URL_GET_ONE_MEMBER_ADDRESS = SERVER_URL_PREFIX + "/receiver/receiver";
    /**
     * NO84、更新单个收获地址列表
     */
    public final static String URL_UPDATE_ONE_MEMBER_ADDRESS = SERVER_URL_PREFIX + "/receiver/update";
    /**
     * NO85、添加单个收获地址列表
     */
    public final static String URL_ADD_ONE_MEMBER_ADDRESS = SERVER_URL_PREFIX + "/receiver/save";
    /**
     * NO86、获取省地区信息
     */
    public final static String URL_GET_PROVINCE_INFO = SERVER_URL_PREFIX + "/area/selectParentList";
    /**
     * NO87、获取市地区信息
     */
    public final static String URL_GET_CITY_INFO = SERVER_URL_PREFIX + "/area/selectChildrenList";
    /**
     * NO88、获取商户基本信息
     */
    public final static String BUS_INFO = SERVER_URL_PREFIX_SHOP + "/bus/businfo";
    /**
     * NO89、获取商户的各类型商品的数量 busbaseId 商户ID
     */
    public final static String GAT_BUS_GOODS_COUNT_BY_ID = SERVER_URL_PREFIX_SHOP + "/goods/goodCountByType";
    /**
     * NO90、判断店铺是否有签到活动，有就返回活动信息
     */
    public final static String URL_JUDGE_STORE_SIGN = SERVER_URL_INTEGRAL + "/integral/bbhs";
    /**
     * NO92、会员店铺签到
     */
    public final static String URL_GET_SIGN_THIS_STORE = SERVER_URL_INTEGRAL + "/integral/busbaseSign";
    /**
     * NO93、获取商户自定义分类
     */
    public final static String GOODS_DIY_CATEGORY = SERVER_URL_ASSISTANT + "/goodsDiyCategory/goodsDiyCategoryTree";
    /**
     * NO94、获取指定图标
     */
    public final static String GET_PING_GO_PPT_NEW = SERVER_URL_PREFIX_SHOP + "/pptIco/lor";
    /**
     * NO95、(按pptKey分组返回) 获取首页所有图片
     **/
    public final static String GET_MAIN_IMAGEBS = "https://shop.globalhexi.cn/shop/pptIco/lorB";
    /**
     * NO96、获取当前抢宝
     */
    public final static String URL_GET_ZC_LIST = SERVER_URL_PREFIX_ZC + "/crowdfunding/crowdfundingRewardList";
    /**
     * NO97、获取热门抢宝
     */
    public final static String URL_GET_HOT_ZC_LIST = SERVER_URL_PREFIX_ZC + "/crowdfunding/heatCrowdfundingRewardList";
    /**
     * NO98、抢宝即将结束
     */
    public final static String URL_GET_QB_JINGDU = SERVER_URL_PREFIX_ZC + "/crowdfunding/gcrps";
    /**
     * NO99、抢宝详情
     */
    public final static String URL_GET_ZC_DETAIL = SERVER_URL_PREFIX_ZC + "/crowdfunding/crowdfundingReward";
    /**
     * NO100、获取会员红包余额
     */
    public final static String URL_GET_MEMBER_HB = SERVER_URL_PREFIX + "/member/redMoney";

    /**
     * NO101、获取抢宝红包使用比列
     */
    public final static String URL_GET_ZC_HB_BL = SERVER_URL_PREFIX_ZC + "/crowdfunding/giftMoneyRatio";
    /**
     * NO102、直接设置支付密码
     */
    public final static String URL_GET_SET_PAY_PWD = SERVER_URL_PREFIX + "/member/setHebiPwd";
    /**
     * NO103、购买抢宝
     */
    public final static String URL_BUY_ZC = SERVER_URL_PREFIX_ZC + "/crowdfunding/purchaseCrowdfundingReward";
    /**
     * NO104、获取我参与的抢宝
     */
    public final static String URL_GET_MY_ZC_LIST = SERVER_URL_PREFIX_ZC + "/crowdfunding/mylist";
    /**
     * NO105、我的抢宝详情
     */
    public final static String URL_GET_ZC_DETAIL_BUYINFO = SERVER_URL_PREFIX_ZC + "/crowdfunding/buyInfo";
    /**
     * NO106、 获取一个开奖记录
     */
    public final static String URL_GET_MY_ZC_LIST_RESULT = SERVER_URL_PREFIX_ZC + "/crowdfunding/crowdfunding";
    /**
     * NO107、获取众筹分类
     */
    public final static String URL_GET_ZC_CLASSES = SERVER_URL_PREFIX_ZC + "/crowdfunding/crowdfundingRewardType";
    /**
     * NO108、抢宝提交评论
     */
    public final static String URL_GET_PL_QBLIST = SERVER_URL_PREFIX_ZC + "/crowdfunding/commentaryList";
    /**
     * NO109、 获取新手专区商品
     */
    public final static String GET_NEWS_GOODS_LIST = SERVER_URL_PREFIX_SHOP + "/goods/bestList";
    /**
     * NO110、 获取首页新人专区图片
     */
    public final static String GET_NEW_USER_GGGG = "https://shop.globalhexi.cn/shop/pptIco/list?pptKey=SY_XRZQ_001";
    /**
     * NO111、新手专区验证码验证成功之后送红包接口
     */
    public final static String URL_CHEAK_IMAGE_CODE = SERVER_URL_PREFIX + "/member/registerGiveMoney";
    /**
     * NO112、获取小分类类分类列表
     */
    public final static String URL_GET_MIN_CLASSES = SERVER_URL_PREFIX_SHOP + "/goods/categoryList";
    /**
     * NO113、获取线上商品列表
     */
    public final static String URL_UP_PRODUCT_LIST2 = SERVER_URL_PREFIX_SHOP + "/goods/upGoodsn";
    /**
     * NO114、获取抢购街类型
     */
    public final static String URL_GET_QGJ_CLASSES = SERVER_URL_PREFIX_QGJ + "/secondskill/seckillGoodsType";
    /**
     * NO115、获取抢购时间段列表
     */
    public final static String URL_GET_QGJ_TIMES = SERVER_URL_PREFIX_QGJ + "/secondskill/goodsSeckilTimeList";
    /**
     * NO116、 获取抢购时间段时间戳
     */
    public final static String URL_GET_QGJ_NOW_TIME2 = SERVER_URL_PREFIX_QGJ + "/secondskill/goodsSeckilTime";
    /**
     * NO117、 获取抢购街商品列表
     */
    public final static String URL_GET_QGJ_PRODUCT_LIST = SERVER_URL_PREFIX_QGJ + "/secondskill/secondskillList";
    /**
     * NO118、通过goodsId获取productId
     */
    public final static String URL_GET_PRODUCTID_BY_GOODSID = SERVER_URL_PREFIX_SHOP + "/goods/goods";
    /**
     * NO119、获取极品推荐店铺
     */
    public final static String GET_JP_MAIN_STORE = SERVER_URL_PREFIX_SHOP + "/bus/recommendJpBusbase";
    /**
     * NO120、获取极品首页分类
     */
    public final static String GET_JP_MAIN_CLASS = SERVER_URL_PREFIX_SHOP + "/jpCategory/goodsForjpCategoryPagingation";
    /**
     * NO121、普通商品下单接口
     */
    public final static String URL_PRODUCT_DOWN_ORDER = SERVER_URL_PREFIX_SHOP + "/order/direct";
    /**
     * NO122、余额支付
     */
    public final static String URL_PAY_YUFUKUAN = SERVER_URL_PREFIX_SHOP + "/pay/payHebi";
    /**
     * NO123、微信支付
     */
    public final static String URL_PAY_WEIXIN = SERVER_URL_PREFIX_SHOP + "/pay/wxpay";
    /**
     * NO124、支付宝支付
     */
    public final static String URL_PAY_ALIPAY = SERVER_URL_PREFIX_SHOP + "/pay/alipay";
    /**
     * NO125、获取代充id
     */
    public final static String GET_MEMBER_BYPTHONE = SERVER_URL_PREFIX + "/member/getMemberBybindPhone";
    /**
     * NO126、创建充值余额订单
     */
    public final static String URL_CREATE_CZ_ORDER = SERVER_URL_PREFIX_SHOP + "/pay/createAccountOrder";
    /**
     * NO127、发起微信余额支付
     */
    public final static String URL_CREATE_WX_YUE_PAY = SERVER_URL_PREFIX_SHOP + "/pay/payCzdd";
    /**
     * NO128、获取极品的广告
     */
    public final static String GOODS_CATEGORY_LIST = SERVER_URL_PREFIX_SHOP + "/goodsCategory/list";
    /**
     * NO129、商品搜索
     */
    public final static String SEARCH_UP_GOODS_LIST2 = SERVER_URL_PREFIX_SHOP + "/goods/searchUpGoodsn";
    /**
     * NO130、获取热门搜索
     */
    public final static String GET_HOT_SEARCH = "https://shop.globalhexi.cn/shop/pptIco/plrm";
    /**
     * NO131、搜索店铺
     */
    public final static String SEARCH_UP_BUSBASE_LIST = SERVER_URL_PREFIX_SHOP + "/goods/shanghuUp";
    /**
     * NO132、获取订单列表
     */
    public final static String URL_GET_ORDER_LIST = SERVER_URL_PREFIX_SHOP + "/order/listByParam";
    /**
     * NO133、订单(确认收货)
     */
    public final static String URL_COMFIR_ORDER = SERVER_URL_PREFIX_SHOP + "/order/yesTake";
    /**
     * NO134、订单(取消申请退款)
     */
    public final static String URL_CANCLE_APPLY_BACK_MONEY = SERVER_URL_PREFIX_SHOP + "/order/unApplyforRefund";
    /**
     * NO135、订单(取消申请退货)
     */
    public final static String URL_CANCLE_APPLY_BACK_PRODUCT = SERVER_URL_PREFIX_SHOP + "/order/unReturned";
    /**
     * NO136、获取订单详情
     */
    public final static String URL_GET_ORDER_DETAIL = SERVER_URL_PREFIX_SHOP + "/order/get";
    /**
     * NO137、订单(申请退款)
     */
    public final static String URL_APPLY_BACK_MONEY = SERVER_URL_PREFIX_SHOP + "/order/applyForRefund";
    /**
     * NO138、订单(申请退货)
     */
    public final static String URL_APPLY_BACK_PRODUCT = SERVER_URL_PREFIX_SHOP + "/order/returned";
    /**
     * NO139、订单(延长收货)
     */
    public final static String URL_LONG_GET_PRODUCTS = SERVER_URL_PREFIX_SHOP + "/order/delayedGoodsReceipt";
    /**
     * NO140、删除订单
     */
    public final static String URL_DELETE_ORDER = SERVER_URL_PREFIX_SHOP + "/order/removeOrder";
    /**
     * NO141、查看物流
     */
    public final static String GET_LOGISTIC = SERVER_URL_PREFIX_SHOP + "/order/mailInfo";

    /**
     * NO142、获取当前订单可用的支付方式
     */
    public final static String GET_PAY_CONFIG_TYPE = SERVER_URL_PREFIX_SHOP + "/pay/paymentConfigType";

/*********************************************红包*************************************************/
    /**
     * NO143、更新红包使用比例
     */
    public final static String URL_UPDATE_HB_MONEY = SERVER_URL_PREFIX_SHOP + "/pay/updateOrderAccountRedMoney";
    /**
     * NO144、店铺精品商品列表
     */
    public final static String URL_GET_STORE_GOODS_LIST = SERVER_URL_PREFIX_SHOP + "/goods/busBestGoodsList";
    /**
     * NO145、获取我的抽奖号码列表
     */
    public final static String GET_DRAW_GOODS_RECORD = SERVER_URL_PREFIX_HB + "/drawGoodsRecord/list";
    /**
     * NO146、获取下注和赚取和币
     */
    public final static String LUCK_GAMES_DETAIL = SERVER_URL_PREFIX_HB + "/luck/detail";
    /**
     * NO147、积分使用记录
     */
    public final static String URL_HB_HISTORY = SERVER_URL_PREFIX_HB + "/integral/scoreRecordPagingation";
    /**
     * NO148、和币兑换现金余额
     */
    public final static String URL_GET_HB_CHANGE_GO = SERVER_URL_INTEGRAL + "/integral/hebiExchangeMoney";
    /**
     * NO149、和币兑换余额比例
     */
    public final static String URL_GET_HB_CHANGE_T = SERVER_URL_INTEGRAL + "/integral/getHebiExchangeRate";
    /**
     * NO150、官方任务列表
     */
    public final static String URL_OFFICIAL_LIST = SERVER_URL_INTEGRAL + "/integral/gpl";
    /**
     * NO151、查询今天是否已签到sign in already
     */
    public final static String URL_SIGN_IN_ALREADY = SERVER_URL_PREFIX + "/member/querySignin";
    /**
     * NO152、签到获取不同等级的积分
     */
    public final static String URL_GET_HB_FOR_QIANDAO = SERVER_URL_PREFIX + "/member/ssbs";
    /**
     * NO153、分页获取兑换列表
     */
    public final static String URL_HB_DH_PRODUCTS = SERVER_URL_PREFIX_HB + "/integral/drawGoodsPagingation";
    /**
     * NO154、获取兑换列表详情
     */
    public final static String URL_HB_DH_PRODUCTS_DETAIL = SERVER_URL_PREFIX_HB + "/integral/drawGoods";
    /**
     * NO155、兑换商品
     */
    public final static String URL_HB_DH_PRODUCTS_BUY = SERVER_URL_PREFIX_HB + "/integral/exchangeDrawGoods";
    /**
     * NO155、转盘抽奖到实体商品兑
     */
    public final static String URL_HB_DH_PRODUCTS_BUY_HX_LUCK = SERVER_URL_PREFIX_HB + "/luck/addAddress";
    /**
     * NO156、获取抽奖商品列表
     */
    public final static String GET_DRAW_GOODS_LIST = SERVER_URL_PREFIX_HB + "/drawGoods/list";
    /**
     * NO157、获取期数
     */
    public final static String GET_DRAW_GOODS_PERIODS = SERVER_URL_PREFIX_HB + "/drawGoods/periods";
    /**
     * NO158、获取中奖公告
     */
    public final static String GET_DRAW_GOODSN_OTIVE = SERVER_URL_PREFIX_HB + "/drawGoods/notive";
    /**
     * NO159、和币兑换现金余额
     */
    public final static String URL_GET_TASK_LIST = SERVER_URL_INTEGRAL + "/integral/getBusbaseSignList";
    /**
     * NO160、幸运抽奖商品
     */
    public final static String LUCK_ALL = SERVER_URL_PREFIX_HB + "/luck/alln";
    /**
     * NO161、开始抽奖新版 req {id:loginId}
     */
    public final static String LUCK_NEW = SERVER_URL_PREFIX_HB + "/luck/nluck";
    /**
     * NO162、获取抽奖商品
     */
    public final static String GET_DRAW_GOODS = SERVER_URL_PREFIX_HB + "/drawGoods/drawGoods";
    /**
     * NO163、抽奖
     */
    public final static String RAFFLE = SERVER_URL_PREFIX_HB + "/drawGoods/raffle";
    /**
     * NO164、游戏记录
     */
    public final static String LUCK_GAMES_RECORD = SERVER_URL_PREFIX_HB + "/luck/luckGamesRecordPagingation";
    /**
     * NO165、获取总积分
     */
    public final static String URL_GET_ALL_HB = SERVER_URL_PREFIX_HB + "/integral/totalScore";
    /**
     * NO166、转发成功后调用
     */
    public final static String URL_SHARE_ARTICLE = SERVER_URL_INTEGRAL + "/integral/gbbfa";
    /**
     * NO167、签到接口sign in
     */
    public final static String URL_SIGN_IN = SERVER_URL_PREFIX + "/member/sibs";

    /**
     * 获取红包列表
     */
    public final static String URL_GET_GIFT_LIST = SERVER_URL_PREFIX_GIFT + "/gift/giftListPagingation";
    /**
     * 获取红包领取记录
     */
    public final static String URL_GIFT_HISTORY_LIST = SERVER_URL_PREFIX_GIFT + "/gift/listGiftRecordPagingation";


    /**
     * 会员发红包
     */
    public final static String URL_SEND_GIFT = SERVER_URL_PREFIX_GIFT + "/gift/createGift";

    /**
     * 获取随机问题
     */
    public final static String URL_GIFT_SOMEONE_PROBLEM = SERVER_URL_PREFIX_GIFT + "/gift/randomGiftProblem";

    /**
     * 获取专属红包问题答案
     */
    public final static String URL_GET_GIFT_ANSER = SERVER_URL_PREFIX_GIFT + "/gift/giftProblem";

    /**
     * 抢红包
     */
    public final static String URL_QIANG_GIFT = SERVER_URL_PREFIX_GIFT + "/gift/clickPersonGift";

    /**
     * 获取会员在某个红包中抢到的金额
     */
    public final static String URL_GET_GIFT_ONE_MONEY = SERVER_URL_PREFIX_GIFT + "/gift/giftMySnatchedMoney";

    /**
     * 获取会员钱包余额
     */
    public final static String URL_GET_MEMBER_HEBI = SERVER_URL_PREFIX + "/member/currency";

    /**
     * 获取会员添加的题目"你喜欢寒老大还是我呢？"
     */
    public final static String URL_GET_PROBLEM_LIST = SERVER_URL_PREFIX_GIFT + "/gift/giftProblemByMemberAdd";
    /**
     * 红包帮助
     */
    public final static String GET_HELP_LIST = SERVER_URL_PREFIX_SHOP + "/help/sendGiftHelpList";

/********************************************评价**************************************************/

    /**
     * 我的评论/晒单列表
     */
    public final static String URL_GET_MY_PL_LIST = SERVER_URL_PREFIX_SHOP + "/commentary/myCommentaryList";
    /**
     * 获取商品评论数量
     */
    public final static String URL_GET_PL_COUNT = SERVER_URL_PREFIX_SHOP + "/commentary/pingjiaCount";
    /**
     * 获取任务列表
     */
    public final static String GET_TASK_LIST = SERVER_URL_PREFIX + "/mtc/gmtl";
    /**
     * 获取任务奖励
     */
    public final static String GET_TASK_MH = SERVER_URL_PREFIX + "/mtc/gmtr";

    /**
     * 获取和粉
     **/
    public final static String GET_HEFENS = SERVER_URL_PREFIX + "/member/gmlll";
    /**
     * 申请添加好友
     */
    public final static String FRIEND_ADD_APPLY_NEW = SERVER_URL_PREFIX + "/friend/apply";
    /**
     * 和粉唤醒记录
     **/
    public final static String ADD_HISTORY = SERVER_URL_PREFIX + "/member/amcr";
    /**
     * 抢宝提交评论
     */
    public final static String URL_SEND_PL_QB = SERVER_URL_PREFIX_ZC + "/crowdfunding/commentary";

    /**
     * 提交评论
     */
    public final static String URL_SEND_PL = SERVER_URL_PREFIX_SHOP + "/commentary/save";

    /**
     * 商户入驻：验证手机号是否已注册
     */
    public final static String BUSBASE_IS_EXISTS = SERVER_URL_ASSISTANT + "/busbase/isExists";
    /**
     * 购物车提交订单
     */
    public final static String URL_CAR_COMFIR_ORDER = SERVER_URL_PREFIX_SHOP + "/order/add";
    /**
     * 购物车设置结算商品
     */
    public final static String URL_GET_CAR_LIST_COMFIR = SERVER_URL_PREFIX_SHOP + "/cart_item/accounts";


    /**
     * 获取用户购物车结算商品信息
     */
    public final static String URL_GET_CAR_LIST_COMFIR_PRODUCTS_INFO = SERVER_URL_PREFIX_SHOP + "/goods/loadConfirmGoodsByCantItem";

    /**
     * 删除回复
     */
    public final static String URL_DELETE_HF = SERVER_URL_PREFIX_NEWS + "/news/removeNewsComment";

    /**
     * 获取关键字/类型
     */
    public final static String URL_FEED_KINDS = SERVER_URL_PREFIX + "/feedBack/list";

    /**
     * 获取反馈列表
     */
    public final static String URL_FEED_LIST = SERVER_URL_PREFIX + "/feedBack/reply";

    /**
     * 添加反馈
     */
    public final static String URL_PUT_FEED = SERVER_URL_PREFIX + "/feedBack/add";


    /**
     * 邀请注册地址（老的）
     */
    public final static String SHARP_REGISTER_ACTION = "http://www.hexichina.com/hexishop/shop/mobilephone!forwordreg.action";
    /**
     * 线上商家邀请入驻地址（老的）
     */
    public final static String XS_INVITATION = "http://www.hexichina.com/hexishop/admin/busbase.jsp";
    /**
     * 商品分享地址(老的)
     */
    public final static String GOODS_SHARP_URL_P = "http://www.globalhexi.com/hexishop/shop/goods!sharePinGoGoods.action";
    public final static String GOODS_SHARP_URL = "http://www.globalhexi.com/hexishop/shop/goods!shareGoods.action";
    /**
     * 店铺分享
     */
    public final static String SHOP_SHERP = "http://www.globalhexi.com/hexishop/shareHtmls/shanghuDetails.html?id=";
    /**
     * 账号申诉短信验证码调用接口
     **/
    public final static String URL_SEND_MOBILE_VALIDATION_CODE_S = SERVER_URL_PREFIX + "/member/asc";
    // 提交申述new
    public final static String SEND_APPLY_TWO = SERVER_URL_PREFIX + "/member/as";

}
