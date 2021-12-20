package com.klen.hrsys.service;


import com.klen.hrsys.entity.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> search();

    SysUser searchById(Integer id);

    SysUser searchByUsername(String name);

    boolean add(SysUser sysUser);

    boolean update(SysUser sysUser);

    boolean delete(Integer id);


}
