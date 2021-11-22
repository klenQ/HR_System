package com.klen.hrsys.service;


import com.klen.hrsys.entity.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> search();

    boolean add(SysRole sysRole);

    boolean delete(Integer id);

    SysRole searchById(Integer id);

    boolean update(SysRole sysRole);
}
