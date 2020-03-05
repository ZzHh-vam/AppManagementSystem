package com.team.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.mapper.AppCategoryMapper;
import com.team.mapper.AppInfoMapper;
import com.team.mapper.AppVersionMapper;
import com.team.mapper.DataDictionaryMapper;
import com.team.pojo.*;
import com.team.service.AppInfoService;
import com.team.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ZzHh
 * @Classname AppInfoServiceImpl
 * @Description TODO
 * @Date: Created in 2020/2/6 18:35
 * @Create By IntelliJ IDEA
 **/

@Service
//所有方法均支持事务
//@Transactional
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private AppCategoryMapper appCategoryMapper;
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;
    @Autowired
    private AppVersionMapper appVersionMapper;

    /**
     *@Function: getCategoryBeloginType
     *@Description: 加载app三级分类
     *@Param: [id]
     *@Return: java.util.List<com.team.pojo.AppCategory>
     **/
    @Override
    public List<AppCategory> getCategoryBeloginType(Long id) {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        if (id == null){
            criteria.andParentidIsNull();
        }else{
            criteria.andParentidEqualTo(id);
        }
        return appCategoryMapper.selectByExample(appCategoryExample);
    }

    /**
     *@Function: getAppPt
     *@Description: 加载所属平台
     *@Param: []
     *@Return: java.util.List<com.team.pojo.DataDictionary>
     **/
    @Override
    public List<DataDictionary> getAppPt() {
        DataDictionaryExample dataDictionaryExample = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypenameEqualTo("所属平台");
        List<DataDictionary> list = dataDictionaryMapper.selectByExample(dataDictionaryExample);
        return list;
    }

    /**
     *@Function: getAppState
     *@Description: 加载app状态
     *@Param: []
     *@Return: java.util.List<com.team.pojo.DataDictionary>
     **/
    @Override
    public List<DataDictionary> getAppState() {
        DataDictionaryExample dataDictionaryExample = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypenameEqualTo("APP状态");
        List<DataDictionary> list = dataDictionaryMapper.selectByExample(dataDictionaryExample);
        return list;
    }

    /**
     *@Function: deleteAppInfo
     *@Description: 删除app信息
     *@Param: [id]
     *@Return: int
     **/
    @Override
    //支持事务注解
    @Transactional
    public int deleteAppInfo(Long id) {
        //思路:先删除外键表的信息,再删除主键表的信息
        //1.实现删除app对应的版本信息
        appVersionMapper.deleteVersionByAppId(id);
        //2.实现删除app信息
        return appInfoMapper.deleteByPrimaryKey(id);  //表示成功
    }

    /**
     *@Function: getAllVersion
     *@Description: 查询app版本信息
     *@Param: [id]
     *@Return: java.util.List<com.team.pojo.AppVersion>
     **/
    @Override
    public List<AppVersion> getAllVersion(Long id) {
        return appVersionMapper.getAllVersion(id);
    }

    /**
     *@Function: getAppVersion
     *@Description: 查询特定app版本信息
     *@Param: [id]
     *@Return: com.team.pojo.AppVersion
     **/
    @Override
    public AppVersion getAppVersionById(Long appId) {
        return appVersionMapper.getAppVersionById(appId);
    }

    /**
     *@Function: watch
     *@Description: 查询单条app信息
     *@Param: [id]
     *@Return: com.team.pojo.AppInfo
     **/
    @Override
    public AppInfo watch(Long id) {
        return appInfoMapper.getSingleAppInfo(id);
    }

    /**
     *@Function: getAllAppInfo
     *@Description: 查询所有app信息
     *@Param: [condition]
     *@Return: com.github.pagehelper.PageInfo<com.team.pojo.AppInfo>
     **/
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)  //挂起  不支持事务
    public PageInfo<AppInfo> getAllAppInfo(Condition condition) {
        PageHelper.startPage(condition.getPage(), condition.getPageSize());
        List<AppInfo> appInfos = appInfoMapper.getAppInfo(condition);
        PageInfo<AppInfo> pageInfo = new PageInfo<>(appInfos);
        return pageInfo;
    }

    /**
     *@Function: addAppInfo
     *@Description: 添加app信息
     *@Param: [appInfo]
     *@Return: int
     **/
    @Override
    public int addAppInfo(AppInfo appInfo) {
        return appInfoMapper.insertSelective(appInfo);
    }

    /**
     *@Function: update
     *@Description: 修改app信息
     *@Param: [appInfo]
     *@Return: int
     **/
    @Override
    public int update(AppInfo appInfo) {
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }

    /**
     *@Function: addVersion
     *@Description: 添加app版本信息
     *@Param: [appVersion]
     *@Return: int
     **/
    @Override
    public int addVersion(AppVersion appVersion) {
        return appVersionMapper.insertSelective(appVersion);
    }

    /**
     *@Function: updateVersion
     *@Description: 修改app版本信息
     *@Param: [appVersion]
     *@Return: int
     **/
    @Override
    public int updateVersion(AppVersion appVersion) {
        return appVersionMapper.updateByPrimaryKeySelective(appVersion);
    }

    /**
     *@Function: getAllApp
     *@Description: 后台管理查询所有app信息
     *@Param: [condition]
     *@Return: com.github.pagehelper.PageInfo<com.team.pojo.AppInfo>
     **/
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)  //挂起  不支持事务
    public PageInfo<AppInfo> getAllApp(Condition condition) {
        PageHelper.startPage(condition.getPage(), condition.getPageSize());
        List<AppInfo> list = appInfoMapper.getAllApp(condition);
        PageInfo<AppInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     *@Function: updateAppInfoState
     *@Description: 修改app的状态
     *@Param: [id, status]
     *@Return: int
     **/
    @Override
    public int updateAppInfoState(Long id, Long status) {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);  //设置主键
        appInfo.setStatus(status);  //设置状态
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }
}
