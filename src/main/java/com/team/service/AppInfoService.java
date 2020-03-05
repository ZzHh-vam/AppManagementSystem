package com.team.service;

import com.github.pagehelper.PageInfo;
import com.team.pojo.AppCategory;
import com.team.pojo.AppInfo;
import com.team.pojo.AppVersion;
import com.team.pojo.DataDictionary;
import com.team.util.Condition;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname AppInfoService
 * @Description TODO
 * @Date: Created in 2020/2/6 18:35
 * @Create By IntelliJ IDEA
 **/

public interface AppInfoService {
    /**
     *@Function: getCategoryBeloginType
     *@Description: 查询一级分类  通过父类型查询子类型  查询父类:传null
     *@Param: [id]
     *@Return: java.util.List<com.team.pojo.AppCategory>
     **/
    List<AppCategory> getCategoryBeloginType(Long id);

    /**
     *@Function: getAppPt
     *@Description: 查询app的平台信息
     *@Param: []
     *@Return: java.util.List<com.team.pojo.DataDictionary>
     **/
    List<DataDictionary> getAppPt();

    /**
     *@Function: getAppState
     *@Description: 查询app的状态信息
     *@Param: []
     *@Return: java.util.List<com.team.pojo.DataDictionary>
     **/
    List<DataDictionary> getAppState();

    /**
     *@Function: del
     *@Description: 删除app信息
     *@Param: [id]
     *@Return: int
     **/
    int deleteAppInfo(Long id);

    /**
     *@Function: getAllVersion
     *@Description: 查询版本信息
     *@Param: [id]
     *@Return: java.util.List<com.team.pojo.AppVersion>
     **/
    List<AppVersion> getAllVersion(Long id);

    /**
     *@Function: getAppVersion
     *@Description: 查询特定app的当前版本信息
     *@Param: [id]
     *@Return: com.team.pojo.AppVersion
     **/
    AppVersion getAppVersionById(Long appId);

    /**
     *@Function: watch
     *@Description: 查单条
     *@Param: [id]
     *@Return: com.team.pojo.AppInfo
     **/
    AppInfo watch(Long id);

    /**
     *@Function: getAllAppInfo
     *@Description: 查询所有app信息
     *@Param: [condition]
     *@Return: com.github.pagehelper.PageInfo<com.team.pojo.AppInfo>
     **/
    PageInfo<AppInfo> getAllAppInfo(Condition condition);

    /**
     *@Function: addAppInfo
     *@Description: 添加app信息
     *@Param: [appInfo]
     *@Return: int
     **/
    int addAppInfo(AppInfo appInfo);

    /**
     *@Function: update
     *@Description: 修改app信息
     *@Param: [appInfo]
     *@Return: int
     **/
    int update(AppInfo appInfo);

    /**
     *@Function: addVersion
     *@Description: 新增app版本信息
     *@Param: [appVersion]
     *@Return: int
     **/
    int addVersion(AppVersion appVersion);

    /**
     *@Function: updateVersion
     *@Description: 修改app版本信息
     *@Param: [appVersion]
     *@Return: int
     **/
    int updateVersion(AppVersion appVersion);

    /**
     *@Function: getAllApp
     *@Description: 后台管理查询所有app信息
     *@Param: [condition]
     *@Return: com.github.pagehelper.PageInfo<com.team.pojo.AppInfo>
     **/
    PageInfo<AppInfo> getAllApp(Condition condition);

    /**
     *@Function: updateAppInfoState
     *@Description: 修改app的状态
     *@Param: [id, status]
     *@Return: int
     **/
    int updateAppInfoState(Long id, Long status);
}
