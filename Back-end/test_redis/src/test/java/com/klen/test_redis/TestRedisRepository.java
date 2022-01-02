package com.klen.test_redis;

import com.klen.test_redis.dao.EmployeeDao;
import com.klen.test_redis.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/22
 */
@SpringBootTest
public class TestRedisRepository {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void setEmp(){
        Employee emp1 = new Employee();
        emp1.setName("李静");
        emp1.setGender("女");
        emp1.setAge(25);
        Employee emp2 = new Employee();
        emp2.setName("王政");
        emp2.setGender("男");
        emp2.setAge(30);
        employeeDao.save(emp1);
        employeeDao.save(emp2);


    }
    @Test
    void getEmps(){
        Iterable<Employee> iterable = employeeDao.findAll();
        Iterator<Employee> iterator = iterable.iterator();
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next.getId()+"::"+next.getName()+"::"+next.getAge()+"::"+next.getGender());

        }


    }

    @Test
    void getEmpByName(){
        Iterable<Employee> iterable = employeeDao.findByName("李静");
        Iterator<Employee> iterator = iterable.iterator();
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next.getId()+"::"+next.getName()+"::"+next.getAge()+"::"+next.getGender());
        }

    }
}
