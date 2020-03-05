package com.team.service.impl;

import com.team.mapper.DevUserMapper;
import com.team.pojo.DevUser;
import com.team.pojo.DevUserExample;
import com.team.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname DevUserServiceImpl
 * @Description TODO
 * @Date: Created in 2020/2/6 17:29
 * @Create By IntelliJ IDEA
 **/

@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    private DevUserMapper devUserMapper;

    /**
     *@Function: selectLogin
     *@Date: 2020/2/6 17:30
     *@Description: 检查用户名密码
     *@Param: [devUser]
     *@Return: java.lang.Integer
     **/
    @Override
    public DevUser login(String username, String password) {
        DevUserExample devUserExample = new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();
        //添加查询条件  select * from 表名
        criteria.andDevcodeEqualTo(username);  //用户名条件
        criteria.andDevpasswordEqualTo(password);  //用户密码条件
        List<DevUser> list = devUserMapper.selectByExample(devUserExample);
        if (list != null && list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
    /*@Override
    public int selectLogin(DevUser devUser) {
        DevUserExample devUserExample = new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();
        if (devUser.getDevcode() != null && devUser.getDevpassword() != null){
            //比较用户名
            criteria.andDevcodeEqualTo(devUser.getDevcode());
            //比较密码
            criteria.andDevpasswordEqualTo(devUser.getDevpassword());
            List<DevUser> list = devUserMapper.selectByExample(devUserExample);
            return list.size();
        }else{
            return -1;
        }
    }*/
}
