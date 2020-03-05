package com.team.controller;

import com.team.pojo.BackendUser;
import com.team.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author ZzHh
 * @Classname BackendUserController
 * @Description TODO
 * @Date: Created in 2020/2/11 13:09
 * @Create By IntelliJ IDEA
 **/

@Controller
public class BackendUserController {
    @Autowired
    private BackendUserService backendUserService;

    @RequestMapping("/loginBackendAction")
    public String loginBackendAction(String username, String password, Model model, HttpSession session){
        //调用业务
        BackendUser backendUser = backendUserService.login(username,password);
        if (backendUser == null){
            //用户名密码不正确,继续登录
            model.addAttribute("info","用户名|密码错误!");
            return "backendlogin";  //返回登录页
        }else{
            //使用session保存登录用户名
            session.setAttribute("loginInfo",backendUser);
            session.setMaxInactiveInterval(10*60);  //session的活动时间是10分钟
            return "backend/main";
        }
    }

    //退出
    @RequestMapping("/backendLoginOut")
    public String backendLoginOut(HttpSession session){
        //清空session  把登录用户名清空
        session.removeAttribute("loginInfo");
        return "redirect:index.jsp";  //返回登录页
    }
}
