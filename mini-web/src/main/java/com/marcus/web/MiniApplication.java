package com.marcus.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.marcus.dao")
@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.marcus.dao", "com.marcus.services", "com.marcus.web.controller"})
public class MiniApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniApplication.class, args);
    }

}
