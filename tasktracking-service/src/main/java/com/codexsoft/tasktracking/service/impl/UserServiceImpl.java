package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.UserDao;
import com.codexsoft.tasktracking.entity.User;
import com.codexsoft.tasktracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
    }

}
