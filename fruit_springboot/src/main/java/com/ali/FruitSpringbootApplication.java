package com.ali;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ali.mapper")
public class FruitSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitSpringbootApplication.class, args);
    }

}
