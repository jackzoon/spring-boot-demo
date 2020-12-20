package com.halen.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.halen.mybatis.mapper"})
public class SpringBootDemoOrmMybatisApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoOrmMybatisApplication.class, args);
  }
}
