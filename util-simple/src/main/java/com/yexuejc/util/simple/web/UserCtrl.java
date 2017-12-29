package com.yexuejc.util.simple.web;

import com.yexuejc.util.base.constant.RespsConstant;
import com.yexuejc.util.base.http.Resps;
import com.yexuejc.util.simple.pojo.User;
import com.yexuejc.util.simple.service.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PackageName: com.yexuejc.util.simple.web
 * @Description:
 * @author: maxf
 * @date: 2017/12/29 16:43
 */
@RestController
public class UserCtrl {
    @Autowired
    UserSrv userSrv;

    /**
     * 获取用户列表
     *
     * @return
     */
    @RequestMapping("/users")
    public Object getUsers() {
        List<User> userList = userSrv.getUsers();
        Resps<List<User>> resps = Resps.success(RespsConstant.MSG_SUCCESS_HTTP);
        resps.setData(userList);
        return resps;
    }
}
