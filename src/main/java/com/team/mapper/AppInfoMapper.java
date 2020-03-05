package com.team.mapper;

import com.team.pojo.AppInfo;
import com.team.pojo.AppInfoExample;
import com.team.util.Condition;

import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    //查询所有app信息
    List<AppInfo> getAppInfo(Condition condition);

    //查询单条app信息
    AppInfo getSingleAppInfo(Long id);

    //查询所有待审核的app信息
    List<AppInfo> getAllApp(Condition condition);
}