package com.halen.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.halen.mybatis.entity.User;
import com.halen.mybatis.mapper.UserMapper;
import com.halen.mybatis.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
