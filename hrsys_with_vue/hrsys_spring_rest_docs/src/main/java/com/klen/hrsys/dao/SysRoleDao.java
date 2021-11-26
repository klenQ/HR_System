package com.klen.hrsys.dao;

import com.klen.hrsys.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysRoleDao extends JpaRepository<SysRole, Integer> {
}
