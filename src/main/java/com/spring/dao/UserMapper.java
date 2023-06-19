package com.spring.dao;

import com.spring.config.MapperBase;
import com.spring.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MapperBase<User> {
    User login(User user);
}
