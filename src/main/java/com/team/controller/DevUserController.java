package com.team.controller;

import com.team.pojo.DevUser;
import com.team.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author ZzHh
 * @Classname DevUserController
 * @Description TODO
 * @Date: Created in 2020/2/6 17:34
 * @Create By IntelliJ IDEA
 **/

@Controller
public class DevUserController {
    @Autowired
    private DevUserService devUserService;

    @RequestMapping("/loginAction")
    public String loginAction(String username, String password, Model model, HttpSession session){
        //调用业务
        DevUser devUser = devUserService.login(username,password);
        if (devUser == null){
            //用户名密码不正确,继续登录
            model.addAttribute("info","用户名|密码不正确");
            return "devlogin";  //返回登录页
        }else{
            //使用session保存登录用户名
            session.setAttribute("loginInfo",devUser);
            session.setMaxInactiveInterval(10*60);  //session的活动时间是10分钟
            return "developer/main";
        }
    }


    //退出
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        //清空session  把登录用户名清空
        session.removeAttribute("loginInfo");
        return "redirect:index.jsp";  //返回登录页
    }

    /*@RequestMapping("/devUserLogin")
    public String devUserLogin(DevUser devUser, Model model){
        int temp = devUserService.selectLogin(devUser);
        if (temp == 1){
            model.addAttribute("devcode",devUser.getDevcode());
            return "redirect:appInfo";
        }else{
            return "403";
        }
    }*/
}
