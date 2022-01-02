package com.klen.hrsys.service.impl;

import com.klen.hrsys.entity.SysPermission;
import com.klen.hrsys.entity.SysRole;
import com.klen.hrsys.entity.SysUser;
import com.klen.hrsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/25
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    SysUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser sysUser = service.searchByUsername(username);
        if (sysUser == null){
            throw new UsernameNotFoundException("username not found");
        }
        List<SysRole> sysRoles = sysUser.getRoles();
        for (SysRole sysRole :
                sysRoles) {
            authorities.add(new SimpleGrantedAuthority(sysRole.getCode()));
            for (SysPermission sysPermission :
                    sysRole.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }


        return new User(sysUser.getUsername(), sysUser.getPassword(),authorities);


    }
    public SysUser toSysUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return service.searchByUsername(user.getUsername());
    }
}
