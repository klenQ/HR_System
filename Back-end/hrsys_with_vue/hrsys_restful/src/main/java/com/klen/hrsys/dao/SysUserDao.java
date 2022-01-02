package com.klen.hrsys.dao;

import com.klen.hrsys.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/20
 */

public interface SysUserDao extends JpaRepository<SysUser, Integer> {


}
