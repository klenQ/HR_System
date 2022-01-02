package com.klen.hrsys.controller;

import com.klen.hrsys.entity.SysPermission;
import com.klen.hrsys.service.SysPermissionService;
import com.klen.hrsys.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("sysPermission")
public class SysPermissionController {

    @Autowired
    SysPermissionService sysPermissionService;

    @GetMapping
    public List<SysPermission> search() {
        return sysPermissionService.search();
    }

    @GetMapping("{id}")
    public SysPermission searchById(@PathVariable Integer id){
        return sysPermissionService.searchById(id);
    }

    @PostMapping
    public boolean add(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.add(sysPermission);
    }

    @PutMapping
    public boolean update(SysPermission sysPermission) {
        return sysPermissionService.update(sysPermission);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        return sysPermissionService.delete(id);
    }
}
