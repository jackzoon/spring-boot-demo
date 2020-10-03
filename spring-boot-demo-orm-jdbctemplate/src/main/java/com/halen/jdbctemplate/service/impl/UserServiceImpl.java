package com.halen.jdbctemplate.service.impl;

import com.halen.jdbctemplate.constant.Const;
import com.halen.jdbctemplate.dao.UserDao;
import com.halen.jdbctemplate.entity.User;
import com.halen.jdbctemplate.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;

@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public Boolean save(User user) {
    String rawPass = user.getPassword();
    String salt = IdUtil.simpleUUID();
    String pass = SecureUtil.md5(rawPass + Const.SALT_PREFIX + salt);
    user.setPassword(pass);
    user.setSalt(salt);
    return userDao.insert(user) > 0;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }

  @Override
  public Boolean update(User user, Long id) {
    return null;
  }

  @Override
  public User getUser(Long id) {
    return null;
  }

  @Override
  public List<User> getUser(User user) {
    return null;
  }
}
