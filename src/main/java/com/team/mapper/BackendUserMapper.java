package com.team.mapper;

import com.team.pojo.BackendUser;
import com.team.pojo.BackendUserExample;
import java.util.List;

public interface BackendUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    List<BackendUser> selectByExample(BackendUserExample example);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
}