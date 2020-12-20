package com.halen.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    log.info("start insert fill ....");
    this.setFieldValByName("createTime", new Date(), metaObject);
    this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    log.info("start update fill ....");
    this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
  }
}
