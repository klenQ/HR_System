package com.klen.test_redis.dao;

import com.klen.test_redis.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/22
 */
@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer> {
    Iterable<Employee> findByName(String name);
}
