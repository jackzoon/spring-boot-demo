package com.halen.dynamic.mapper;

import com.halen.dynamic.config.MyMapper;
import com.halen.dynamic.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}
