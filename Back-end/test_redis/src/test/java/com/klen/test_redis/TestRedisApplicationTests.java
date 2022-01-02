package com.klen.test_redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;

@SpringBootTest
class TestRedisApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void setString(){
        redisTemplate.opsForValue().set("name","Tom");
    }

    @Test
    void getString(){
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void updateString(){
        String name = redisTemplate.opsForValue().getAndSet("name","李静");
    }

    @Test
    void deleteString(){
        Boolean flag = redisTemplate.delete("name");

    }

    @Test
    void setList(){
        redisTemplate.opsForList().leftPush("emps","王正");
        String[] strs = {"李静","陈建"};
        redisTemplate.opsForList().leftPushAll("emps",strs);
        ArrayList<String> list = new ArrayList<>();
        list.add("赵杰");
        list.add("孙悦");
        redisTemplate.opsForList().leftPushAll("emps",list);

    }

    @Test
    void getList(){
        System.out.println(redisTemplate.opsForList().index("emps",0));
    }

}
