package com.klen.hrsys.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/17
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("loginError")
    public String showLoginError(){
        return "loginError";
    }
    @RequestMapping("roleError")
    public String showRoleError(){
        return "roleError";
    }
}
