package com.klen.hrsys.dao;

import com.klen.hrsys.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysPermissionDao extends JpaRepository<SysPermission, Integer> {
}
