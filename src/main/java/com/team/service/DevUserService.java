package com.team.service;

import com.team.pojo.DevUser;

/**
 * @Author ZzHh
 * @Classname DevUserService
 * @Description TODO
 * @Date: Created in 2020/2/6 17:27
 * @Create By IntelliJ IDEA
 **/

public interface DevUserService {
    //实现登录
    //验证是否存在此用户
    //返回用户实体,若返回null则没有用户
    //若不为null,则获取用户的信息
    DevUser login(String username, String password);
    /*int selectLogin(DevUser devUser);*/
}
