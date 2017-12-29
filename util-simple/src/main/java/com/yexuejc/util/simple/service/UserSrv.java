package com.yexuejc.util.simple.service;

import com.yexuejc.util.simple.pojo.User;

import java.util.List;

/**
 * 用户处理
 *
 * @PackageName: com.yexuejc.util.simple.service
 * @Description:
 * @author: maxf
 * @date: 2017/12/29 10:15
 */
public interface UserSrv {
    /**
     * 批量添加User
     *
     * @param userList
     * @return
     */
    boolean addUsers(List<User> userList);

    /**
     * 添加User
     *
     * @return
     */
    boolean addUser(User user);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getUsers();
}
