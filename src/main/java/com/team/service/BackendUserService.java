package com.team.service;

import com.team.pojo.BackendUser;

/**
 * @Author ZzHh
 * @Classname BackendUserService
 * @Description TODO
 * @Date: Created in 2020/2/11 12:58
 * @Create By IntelliJ IDEA
 **/

public interface BackendUserService {
    //实现登录
    //验证是否存在此用户
    //返回用户实体,若返回null则没有用户
    //若不为null,则获取用户的信息
    BackendUser login(String username, String password);
}
