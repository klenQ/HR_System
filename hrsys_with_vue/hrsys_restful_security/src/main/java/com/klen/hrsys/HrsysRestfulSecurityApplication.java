package com.klen.hrsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HrsysRestfulSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrsysRestfulSecurityApplication.class, args);
    }

}
