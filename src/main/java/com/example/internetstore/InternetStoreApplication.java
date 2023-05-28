package com.example.internetstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@MapperScan("com.example.internetstore.mapper")//扫描此目录下，全部引入，当作mapper,项目启动自动加载
public class InternetStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternetStoreApplication.class, args);
    }

}
