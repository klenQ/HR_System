package com.klen.test_redis;

import com.klen.test_redis.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/21
 */
@SpringBootTest
public class TestEmployee {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void setEmp(){
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("李静");
        emp1.setGender("女");
        emp1.setAge(25);
        redisTemplate.opsForValue().set("emp1",emp1);

    }
}
