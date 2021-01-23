package com.halen.cache.service;

import com.halen.cache.model.User;

public interface UserService {
    User saveOrUpdate(User user);
    User get(Long id);
    void delete(Long id);
}
