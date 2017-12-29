package com.yexuejc.util.simple.domain;

import com.yexuejc.util.simple.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User 持久化处理
 * @PackageName: com.yexuejc.util.simple
 * @Description:
 * @author: maxf
 * @date: 2017/12/29 10:23
 */
@Mapper
public interface UserMapper {

    /**
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 
     * @return
     */
    List<User> getUsers();
}
