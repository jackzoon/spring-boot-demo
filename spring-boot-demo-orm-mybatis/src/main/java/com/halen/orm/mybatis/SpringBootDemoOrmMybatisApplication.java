package com.halen.orm.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.halen.orm.mybatis.mapper"})
@SpringBootApplication
public class SpringBootDemoOrmMybatisApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoOrmMybatisApplication.class, args);
  }
}
