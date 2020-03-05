package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.pojo.*;
import com.team.service.AppInfoService;
import com.team.util.Condition;
import com.team.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @Author ZzHh
 * @Classname AppInfoController
 * @Description TODO
 * @Date: Created in 2020/2/6 18:34
 * @Create By IntelliJ IDEA
 **/

@Controller
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;

    /**
     *@Function: appInfo
     *@Description: 查询所有app信息
     *@Param: [condition, model]
     *@Return: java.lang.String
     **/
    @RequestMapping("/allAppInfo")
    public String appInfo(Condition condition, Model model, HttpSession session){
        //给查询条件添加用户id
        //从session取出登录用户的id
        DevUser devUser = (DevUser) session.getAttribute("loginInfo");
        condition.setDevid(devUser.getId());

        PageInfo<AppInfo> pageInfo = appInfoService.getAllAppInfo(condition);
        model.addAttribute("pageInfo",pageInfo);
        //还原表单(实现查询条件的回显)
        model.addAttribute("condition",condition);
        return "developer/appinfo";
    }

    /**
     *@Function: getCategroyByParentId
     *@Description: 获取三级目录
     *@Param: [id]
     *@Return: java.util.List<com.team.pojo.AppCategory>
     **/
    @RequestMapping("/getCategroyByParentId")
    @ResponseBody
    public List<AppCategory> getCategroyByParentId(Long id){
        List<AppCategory> list = appInfoService.getCategoryBeloginType(id);
        return list;
    }

    /**
     *@Function: getAppState
     *@Description: 获取状态信息
     *@Param: []
     *@Return: java.util.List<com.team.pojo.DataDictionary>
     **/
    @RequestMapping("/getAppState")
    @ResponseBody
    public List<DataDictionary> getAppState(){
        List<DataDictionary> list = appInfoService.getAppState();
        return list;
    }

    /**
     *@Function: getAppPt
     *@Description: 获取平台信息
     *@Param: []
     *@Return: java.util.List<com.team.pojo.DataDictionary>
     **/
    @RequestMapping("/getAppPt")
    @ResponseBody
    public List<DataDictionary> getAppPt(){
        List<DataDictionary> list = appInfoService.getAppPt();
        return list;
    }

    /**
     *@Function: del
     *@Description: 删除app信息  接收编号
     *@Param: [id]
     *@Return: java.lang.String
     **/
    @RequestMapping("/delAppInfo")
    public String delAppInfo(Long id, String oldPath){
        //调用业务实现删除
        try {
            int temp = appInfoService.deleteAppInfo(id);
            System.out.println(oldPath);
            File file = new File("E:/JavaSpace/IDEA/AppManagementSystem/src/main/webapp" + oldPath);
            file.delete();
        }catch (Exception e){
            return "redirect:error.jsp";
        }
        return "redirect:allAppInfo";
    }

    /**
     *@Function: getSingleAppInfo
     *@Description: 获取单条app信息
     *@Param: [id, model]
     *@Return: java.lang.String
     **/
    @RequestMapping("/getSingleAppInfo")
    public String getSingleAppInfo(Long id, Model model){
        AppInfo appInfo = appInfoService.watch(id);
        List<AppVersion> list = appInfoService.getAllVersion(id);
        String logopicpath = "../.." + (appInfo.getLogopicpath().substring(14));
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("list",list);
        model.addAttribute("logopicpath",logopicpath);
        return "developer/appinfoview";
    }

    /**
     *@Function: addAppInfo
     *@Description: 实现app信息添加  实现文件上传
     *@Param: [file, request]
     *@Return: java.lang.String
     **/
    @RequestMapping("/addAppInfo")
    public String addAppInfo(AppInfo appInfo, @RequestParam(name = "a_logoPicPath",required = false) CommonsMultipartFile file,
                             HttpServletRequest request, HttpSession session) throws Exception {
        //1.实现文件上传
        //1.1获取上传文件的信息
        /*System.out.println("获取上传文件名称:" + file.getOriginalFilename());
        System.out.println("获取上传文件的大小:" + file.getSize());
        System.out.println("获取上传文件的类型:" + file.getContentType());*/
        //1.2上传文件
        //获取保存位置将相对路径转化为绝对路径
        String path = request.getSession().getServletContext().getRealPath("statics/uploadfiles");
        //设置保存文件
        String fileName = FileUploadUtil.upload(file,path);
        //2.调用业务层将信息添加到数据库中
        //设置图片相对路径保存到数据库
        appInfo.setLogopicpath("/AppInfoSystem/statics/uploadfiles/" + fileName);
        appInfo.setLogolocpath(path + fileName);

        //3.给实体添加用户id属性值
        DevUser devUser = (DevUser) session.getAttribute("loginInfo");
        appInfo.setDevid(devUser.getId());  //从session中获取id

        appInfoService.addAppInfo(appInfo);
        //保存绝对路径appInfo.setLogolocpath(savePos);
        return "redirect:allAppInfo";  //返回页面
    }

    /**
     *@Function: updateAppInfo
     *@Description: 修改app信息
     *@Param: [id, model]
     *@Return: java.lang.String
     **/
    @RequestMapping("/updateAppInfo")
    public String updateAppInfo(Long id, Model model){
        AppInfo appInfo = appInfoService.watch(id);
        List<AppVersion> list = appInfoService.getAllVersion(id);
        String logopicpath = appInfo.getLogopicpath().substring(14);
        String fileName = (appInfo.getLogopicpath()).substring((appInfo.getLogopicpath()).lastIndexOf("/")+1);
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("list",list);
        model.addAttribute("logopicpath",logopicpath);
        model.addAttribute("fileName",fileName);
        return "developer/appinfomodify";
    }

    /**
     *@Function: update
     *@Description: 修改app
     *@Param: [appInfo, oldPicPath, file, request]
     *@Return: java.lang.String
     **/
    @RequestMapping("/update")
    public String update(AppInfo appInfo,String oldPicPath , @RequestParam(name = "a_logoPicPath",required = false) CommonsMultipartFile file,
                         HttpServletRequest request) {
        try {
            //判断图片是否上传
            String fileName = file.getOriginalFilename();
            if (!fileName.equals("")){
                //1.上传文件
                String path = request.getSession().getServletContext().getRealPath("statics/uploadfiles");
                fileName = FileUploadUtil.upload(file,path);

                //2.调用业务层将信息添加到数据库中
                //设置图片相对路径保存到数据库
                appInfo.setLogopicpath("/AppInfoSystem/statics/uploadfiles/" + fileName);
                //保存绝对路径appInfo.setLogolocpath(savePos);
                appInfo.setLogolocpath(path + fileName);

                //删除原图片
                File file1 = new File("E:/JavaSpace/IDEA/AppManagementSystem/src/main/webapp" + oldPicPath);
                file1.delete();  //删除原图片
            }
            //2.修改基本信息
            appInfoService.update(appInfo);
        }catch (Exception e){
            return "redirect:error.jsp";
        }
        return "redirect:allAppInfo";  //返回页面
    }

    /**
     *@Function: getAllVersion
     *@Description: 获取所有app版本信息
     *@Param: [id, model]
     *@Return: java.lang.String
     **/
    @RequestMapping("/getAllVersion")
    public String getAllVersion(Long id, Model model){
        List<AppVersion> list = appInfoService.getAllVersion(id);
        model.addAttribute("list",list);
        //将appId保存到作用域
        model.addAttribute("appId",id);
        return "developer/appversionadd";
    }

    /**
     *@Function: addVersion
     *@Description: 添加app版本信息
     *@Param: [appVersion]
     *@Return: java.lang.String
     **/
    @RequestMapping("/addVersion")
    public String addVersion(@RequestParam(name = "a_downloadlink",required = false)CommonsMultipartFile file,
                             HttpServletRequest request, AppVersion appVersion){
        try {
            //1.上传app文件  app文件保存到项目的upload/apk目录中
            //设置保存文件的位置
            String path = request.getSession().getServletContext().getRealPath("upload/apk");
            String fileName = FileUploadUtil.upload(file,path);  //上传
            //2.将信息保存到数据库
            //设置实体的apk文件名称
            appVersion.setApkfilename(file.getOriginalFilename());
            //设置实体的apk文件的相对路径
            appVersion.setDownloadlink("upload/apk/" + fileName);
            appInfoService.addVersion(appVersion);
            AppInfo appInfo = appInfoService.watch(appVersion.getAppid());
            appInfo.setVersionid(appVersion.getId());
            appInfoService.update(appInfo);
            return "redirect:allAppInfo";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:error.jsp";
    }

    /**
     *@Function: getAllVersions
     *@Description: 获取所有版本信息
     *@Param: [id, model]
     *@Return: java.lang.String
     **/
    @RequestMapping("/getAllVersions")
    public String getAllVersions(Long id, Model model){
        List<AppVersion> list = appInfoService.getAllVersion(id);
        AppVersion appVersion = appInfoService.getAppVersionById(id);
        model.addAttribute("list",list);
        model.addAttribute("appVersion",appVersion);
        model.addAttribute("appId",id);
        return "developer/appversionmodify";
    }

    /**
     *@Function: updateVersion
     *@Description: 修改版本信息
     *@Param: [appVersion]
     *@Return: java.lang.String
     **/
    @RequestMapping("/updateVersion")
    public String updateVersion(@RequestParam(name = "attach",required = false)CommonsMultipartFile file,
                                HttpServletRequest request, AppVersion appVersion, String oldPicPath){
        try {
            //判断图片是否上传
            String fileName = file.getOriginalFilename();
            if (!fileName.equals("")) {
                //1.上传文件
                String path = request.getSession().getServletContext().getRealPath("upload/apk");
                fileName = FileUploadUtil.upload(file, path);

                //2.调用业务层将信息添加到数据库中
                //设置图片相对路径保存到数据库
                appVersion.setDownloadlink("/AppInfoSystem/upload/apk/" + fileName);
                //保存绝对路径appInfo.setLogolocpath(savePos);
                appVersion.setApklocpath(path + fileName);
                appVersion.setApkfilename(file.getOriginalFilename());

                //删除原文件
                String deletePath = oldPicPath.substring(14);
                File file1 = new File("E:/JavaSpace/IDEA/AppManagementSystem/src/main/webapp" + deletePath);
                file1.delete();  //删除原文件
            }
            appInfoService.updateVersion(appVersion);
            appVersion.setCreatedby(new Long(1));
        }catch (Exception e){
            return "developer/appversionmodify";
        }
        return "redirect:allAppInfo";
    }

    @RequestMapping("/auditingStatus")
    public String auditingStatus(Long id, Long status){
        int temp = appInfoService.updateAppInfoState(id,status);
        if (temp > 0) {
            return "redirect:getAllApp";
        }else{
            return "redirect:error.jsp";
        }
    }

    @RequestMapping("/upperAndLowerFrames")
    @ResponseBody
    public String upperAndLowerFrames(Long id, Long status){
        //调用业务
        int temp = appInfoService.updateAppInfoState(id,status);
        if (temp > 0) {
            return "{\"result\":\"1\"}";  //1表示成功
        }else{
            return "{\"result\":\"0\"}";  //0表示失败
        }
    }
}
