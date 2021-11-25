package com.klen.hrsys.dao;

import com.klen.hrsys.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/20
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {


}
