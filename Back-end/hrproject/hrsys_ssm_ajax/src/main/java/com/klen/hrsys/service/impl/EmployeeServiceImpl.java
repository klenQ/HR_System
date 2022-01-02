package com.klen.hrsys.service.impl;

import com.klen.hrsys.dao.EmployeeDao;
import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> search(Employee condition) {
        return employeeDao.search(condition);
    }

    @Override
    public Employee searchById(Integer id) {
        return employeeDao.searchById(id);
    }

    @Override
    public boolean add(Employee emp) {
        int add = employeeDao.add(emp);
        return add > 0;
    }

    @Override
    public boolean update(Employee emp) {
        int update = employeeDao.update(emp);
        return update > 0;

    }

    @Override
    public boolean delete(Integer id) {
        int delete = employeeDao.delete(id);
        return delete > 0;
    }
}
