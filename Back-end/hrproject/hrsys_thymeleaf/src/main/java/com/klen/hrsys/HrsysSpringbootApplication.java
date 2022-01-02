package com.klen.hrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.klen.hrsys.dao")
public class HrsysSpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(HrsysSpringbootApplication.class, args);


    }

}
