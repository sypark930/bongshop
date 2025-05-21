package com.bongmall.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@MapperScan(basePackages = {"com.bongmall.basic.**"})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // 시큐리티 기능 해제.
public class Bongshop1Application {

    public static void main(String[] args) {
        SpringApplication.run(Bongshop1Application.class, args);
    }

}
