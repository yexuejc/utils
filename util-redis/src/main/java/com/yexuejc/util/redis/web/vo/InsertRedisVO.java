package com.yexuejc.util.redis.web.vo;

import com.yexuejc.util.base.pojo.BaseVO;
import com.yexuejc.util.base.util.JsonUtil;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增redis数据vo
 *
 * @PackageName: com.yexuejc.util.redis
 * @Description:
 * @author: maxf
 * @date: 2018/1/17 13:55
 */
public class InsertRedisVO extends BaseVO {
    @NotBlank(message = "key为空")
    private String key;
    @NotBlank(message = "value为空")
    private String value;

    /**
     * redis库
     */
    private int db = 0;
    /**
     * 类型：头
     */
    private String type;

    public InsertRedisVO setRedis(int db, String type) {
        this.db = db;
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.obj2Json(this);
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
