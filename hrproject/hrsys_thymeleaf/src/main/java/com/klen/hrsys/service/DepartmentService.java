package com.klen.hrsys.service;

import com.klen.hrsys.entity.Department;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */
public interface DepartmentService {
    public List<Department> search();

    public Department searchById(Integer id);

    public boolean add(Department dep);

    public boolean update(Department dep);

    public boolean delete(Integer id);
}
