package com.dragon.banana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dragon.banana.mapper")
public class BananaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BananaApplication.class, args);
    }

}
