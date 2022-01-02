package com.klen.hrsys.controller;

import com.klen.hrsys.entity.SysRole;
import com.klen.hrsys.entity.SysUser;
import com.klen.hrsys.service.SysRoleService;
import com.klen.hrsys.service.SysUserService;
import com.klen.hrsys.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping("/currentUser")
    public SysUser currentUserName() {
        SysUser user=null;
        try {

            user=userDetailsServiceImpl.toSysUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @GetMapping
    public List<SysUser> search() {
        return sysUserService.search();
    }

    @GetMapping("{id}")
    public SysUser searchById(@PathVariable Integer id){
        return sysUserService.searchById(id);
    }

    @PostMapping
    public boolean add(@RequestBody SysUser sysUser) {
        return sysUserService.add(sysUser);
    }

    @PutMapping
    public boolean update(@RequestBody SysUser sysUser) {
        return sysUserService.update(sysUser);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        return sysUserService.delete(id);
    }
}
