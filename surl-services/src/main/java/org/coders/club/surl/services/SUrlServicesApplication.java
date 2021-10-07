package org.coders.club.surl.services;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SUrlServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SUrlServicesApplication.class, args);
    }
}
