package com.klen.hrsys.service.impl;


import com.klen.hrsys.dao.SysUserDao;
import com.klen.hrsys.entity.SysUser;
import com.klen.hrsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public List<SysUser> search() {
        return sysUserDao.findAll();
    }

    @Override
    public SysUser searchById(Integer id) {
        return sysUserDao.findById(id).get();
    }

    @Override
    public SysUser searchByUsername(String name) {
        return sysUserDao.findByUsername(name);
    }

    @Override
    public boolean add(SysUser sysUser) {
        SysUser newUser = sysUserDao.save(sysUser);
        return newUser != null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            sysUserDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(SysUser sysUser) {
        SysUser newUser = sysUserDao.save(sysUser);
        return newUser != null;
    }

}
