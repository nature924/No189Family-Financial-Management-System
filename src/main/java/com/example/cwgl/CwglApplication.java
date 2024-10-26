package com.example.cwgl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.example.cwgl.dao")
@EnableTransactionManagement
@SpringBootApplication
public class CwglApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CwglApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(CwglApplication.class);
    }
}
