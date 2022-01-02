package com.klen.hrsys.controller;

import com.klen.hrsys.entity.SysPermission;
import com.klen.hrsys.entity.SysRole;
import com.klen.hrsys.entity.SysUser;
import com.klen.hrsys.service.SysPermissionService;
import com.klen.hrsys.service.SysRoleService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysRole")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @GetMapping
    public List<SysRole> search() {
        return sysRoleService.search();
    }

    @GetMapping("{id}")
    public SysRole searchById(@PathVariable Integer id){
        return sysRoleService.searchById(id);
    }

    @PostMapping
    public boolean add(@RequestBody SysRole sysRole) {
        return sysRoleService.add(sysRole);
    }

    @PutMapping
    public boolean update(@RequestBody SysRole sysRole) {
        return sysRoleService.update(sysRole);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        return sysRoleService.delete(id);
    }
}
