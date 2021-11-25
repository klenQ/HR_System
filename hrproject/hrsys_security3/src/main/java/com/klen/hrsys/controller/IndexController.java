package com.klen.hrsys.controller;

import com.klen.hrsys.entity.SysUser;
import com.klen.hrsys.service.SysUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping({"index","/"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        SysUser sysUser = sysUserService.searchByUsername(username);
        mv.addObject("user",sysUser);
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
