package com.htb.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.htb.api.mapper") //扫描的mapper
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }




}
