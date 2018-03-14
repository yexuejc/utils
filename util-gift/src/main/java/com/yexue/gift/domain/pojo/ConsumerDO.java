package com.yexue.gift.domain.pojo;

import com.yexuejc.util.base.pojo.BaseDO;

import java.util.List;

/**
 * 消费用户DO
 * 
 * @author yexue
 * @expl
 * @time 2017年11月10日 下午2:46:06
 */
public class ConsumerDO extends BaseDO {
    private static final long serialVersionUID = -7929815511987686496L;

    /** 消费者用户主键ID */
    private String consumerId;
    /** 用户code */
    private String code;
    /** 账户手机号 */
    private String mobile;
    /** 微信登录openID */
    private String wechatId;
    /** QQ登录openID */
    private String qqId;
    /** 微博登录openID */
    private String weiboId;
    /** 密码 */
    private String pwd;
    /** 昵称 */
    private String consumerAlias;
    /** 头像 */
    private String head;
    /** 等级 */
    private String consumerLevel;
    /** 父级ID */
    private String parentId;
    /** 所属家族ID */
    private String familyId;
    /** 下线总人数 */
    private Integer subNum;
    /** 角色 */
    private List<String> roles;
    /** 登录token */
    private String token;
    /** 支付密码 */
    private String payPwd;
    /** 该账户是否启用 */
    private Boolean enable;
    /** 该账户是否没有过期 */
    private Boolean nonExpire;
    /** 该账户是否没有被锁定 */
    private Boolean nonLock;
    /** 账户活跃度 */
    private Integer active;

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(String weiboId) {
        this.weiboId = weiboId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConsumerAlias() {
        return consumerAlias;
    }

    public void setConsumerAlias(String consumerAlias) {
        this.consumerAlias = consumerAlias;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getConsumerLevel() {
        return consumerLevel;
    }

    public void setConsumerLevel(String consumerLevel) {
        this.consumerLevel = consumerLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public Integer getSubNum() {
        return subNum;
    }

    public void setSubNum(Integer subNum) {
        this.subNum = subNum;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getNonExpire() {
        return nonExpire;
    }

    public void setNonExpire(Boolean nonExpire) {
        this.nonExpire = nonExpire;
    }

    public Boolean getNonLock() {
        return nonLock;
    }

    public void setNonLock(Boolean nonLock) {
        this.nonLock = nonLock;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

}
