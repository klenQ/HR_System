package com.klen.hrsys.dao;

import com.klen.hrsys.entity.Department;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */
public interface DepartmentDao {
    List<Department> search();

    Department searchById(int id);

    int update(Department department);

    int add(Department department);

    int delete(int id);

}
