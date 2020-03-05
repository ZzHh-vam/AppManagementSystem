package com.team.mapper;

import com.team.pojo.AppVersion;
import com.team.pojo.AppVersionExample;
import java.util.List;

public interface AppVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    List<AppVersion> selectByExample(AppVersionExample example);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    //查询所有版本信息
    List<AppVersion> getAllVersion(Long id);

    //通过app的编号删除对应的版本
    int deleteVersionByAppId(Long id);

    AppVersion getAppVersionById(Long appId);
}