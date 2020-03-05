package com.team.service.impl;

import com.team.mapper.AppInfoMapper;
import com.team.mapper.BackendUserMapper;
import com.team.pojo.BackendUser;
import com.team.pojo.BackendUserExample;
import com.team.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname BackendUserServiceImpl
 * @Description TODO
 * @Date: Created in 2020/2/11 12:58
 * @Create By IntelliJ IDEA
 **/

@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private BackendUserMapper backendUserMapper;

    @Override
    public BackendUser login(String username, String password) {
        BackendUserExample backendUserExample = new BackendUserExample();
        BackendUserExample.Criteria criteria = backendUserExample.createCriteria();
        criteria.andUsercodeEqualTo(username);
        criteria.andUserpasswordEqualTo(password);
        List<BackendUser> list = backendUserMapper.selectByExample(backendUserExample);
        if (list != null && list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
}
