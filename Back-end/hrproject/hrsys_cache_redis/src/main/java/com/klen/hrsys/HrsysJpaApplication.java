package com.klen.hrsys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HrsysJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrsysJpaApplication.class, args);
    }

}
