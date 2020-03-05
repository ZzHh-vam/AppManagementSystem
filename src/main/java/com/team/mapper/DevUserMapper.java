package com.team.mapper;

import com.team.pojo.DevUser;
import com.team.pojo.DevUserExample;
import java.util.List;

public interface DevUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    List<DevUser> selectByExample(DevUserExample example);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}