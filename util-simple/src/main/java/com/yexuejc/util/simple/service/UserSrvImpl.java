package com.yexuejc.util.simple.service;

import com.yexuejc.util.simple.domain.UserMapper;
import com.yexuejc.util.simple.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户处理
 *
 * @PackageName: com.yexuejc.util.simple.service
 * @Description:
 * @author: maxf
 * @date: 2017/12/29 10:16
 */
@Service
public class UserSrvImpl implements UserSrv {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addUsers(List<User> userList) {
        int result = 1;
        for (User user : userList) {
            result = userMapper.saveUser(user);
        }
        return result > 0;
    }

    @Override
    public boolean addUser(User user) {
        int result = userMapper.saveUser(user);
        return result > 0;
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
