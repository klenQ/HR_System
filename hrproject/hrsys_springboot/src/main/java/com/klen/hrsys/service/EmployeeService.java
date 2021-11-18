package com.klen.hrsys.service;

import com.klen.hrsys.entity.Employee;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */
public interface EmployeeService {
    List<Employee> search(Employee condition);
    Employee searchById(Integer id);
    boolean add(Employee emp);
    boolean update(Employee emp);
    boolean delete(Integer id);
}
