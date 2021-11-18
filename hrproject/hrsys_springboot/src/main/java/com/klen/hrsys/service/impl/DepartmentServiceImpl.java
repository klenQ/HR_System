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
        List<Department> list = depDao.search();
        return list;
    }

    @Override
    public Department searchById(Integer id) {
        Department dep = depDao.searchById(id);
        return dep;
    }

    @Override
    public boolean add(Department dep) {
        int rs = depDao.add(dep);
        return rs > 0;
    }

    @Override
    public boolean update(Department dep) {
        int rs = depDao.update(dep);
        return rs > 0;
    }

    @Override
    public boolean delete(Integer id) {
        int rs = depDao.delete(id);
        rs = empDao.updateByDep(id);
        return rs > 0;
    }
}
