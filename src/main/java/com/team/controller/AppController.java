package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.pojo.AppInfo;
import com.team.pojo.AppVersion;
import com.team.service.AppInfoService;
import com.team.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author ZzHh
 * @Classname AppController
 * @Description TODO
 * @Date: Created in 2020/2/11 13:50
 * @Create By IntelliJ IDEA
 **/

@Controller
public class AppController {
    @Autowired
    private AppInfoService appInfoService;

    @RequestMapping("/getAllApp")
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public String getAllApp(Model model, Condition condition){
        condition.setStatus(new Long(1));
        PageInfo<AppInfo> pageInfo = appInfoService.getAllApp(condition);
        model.addAttribute("pageInfo",pageInfo);
        //还原表单(实现查询条件的回显)
        model.addAttribute("condition",condition);
        return "backend/applist";
    }

    @RequestMapping("/getSinglerApp")
    public String getSinglerAp(Long appId, Model model){
        AppInfo appInfo = appInfoService.watch(appId);
        AppVersion appVersion = appInfoService.getAppVersionById(appId);
        String logopicpath = "../.." + (appInfo.getLogopicpath().substring(14));
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("appVersion",appVersion);
        model.addAttribute("logopicpath",logopicpath);
        return "backend/appcheck";
    }
}
