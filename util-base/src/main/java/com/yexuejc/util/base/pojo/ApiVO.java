package com.yexuejc.util.base.pojo;


import com.yexuejc.util.base.http.Resps;
import com.yexuejc.util.base.util.JsonUtil;

/**
 * 接口交互APi
 *
 * @PackageName: com.mcworle.ecentm.api.user.web.vo
 * @Description:
 * @author: maxf
 * @date: 2018/1/17 11:36
 */
public class ApiVO {
    public enum STATUS {
        S, F, E
    }

    /**
     * 状态
     */
    private STATUS status = STATUS.S;
    /**
     * code
     */
    private String code;
    /**
     * 消息
     */
    private String msg;


    /**
     * 值1
     */
    private Object object1;
    /**
     * 值2
     */
    private Object object2;

    public <T extends Object> void setObject1(T obj) {
        object1 = obj;
    }

    public <T extends Object> T getObject1(Class<T> clazz) {
        return (T) object1;
    }

    public <T extends Object> void setObject2(T obj) {
        object2 = obj;
    }

    public <T extends Object> T getObject2(Class<T> clazz) {
        return (T) object2;
    }


    public boolean isSucc() {
        if (STATUS.S.equals(status.name())) {
            return true;
        }
        return false;
    }

    public boolean isFail() {
        return !isSucc();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return JsonUtil.obj2Json(this);
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//测试代码
//    public static void main(String[] args) {
//        ApiVO apiVO = new ApiVO();
//        apiVO.setStatus(STATUS.F);
//        apiVO.setObject1(Resps.success("测试"));
//        apiVO.setObject2("asasasas");
//        System.out.println(apiVO.toString());
//        System.out.println(apiVO.isSucc() + "");
//        Resps r = apiVO.getObject1(Resps.class);
//        System.out.println(r);
//        System.out.println(apiVO.getObject2(String.class));
//    }

}
