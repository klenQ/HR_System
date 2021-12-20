package com.klen.hrsys.service.impl;

import com.klen.hrsys.dao.DepartmentDao;
import com.klen.hrsys.dao.EmployeeDao;
import com.klen.hrsys.entity.Department;
import com.klen.hrsys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao depDao;
    @Autowired
    EmployeeDao empDao;

    @Override
    public List<Department> search() {
        return depDao.findAll();
    }

    @Override
    public Department searchById(Integer id) {
        return depDao.findById(id).get();
    }

    @Override
    public boolean add(Department dep) {
        Department newDep = depDao.save(dep);
        return newDep != null;
    }

    @Override
    public boolean update(Department dep) {
        Department newDep = depDao.save(dep);
        return newDep != null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            depDao.deleteById(id);
            empDao.updateByDep(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
