package com.codexsoft.tasktracking.dao.impl;

import com.codexsoft.tasktracking.dao.UserDao;
import com.codexsoft.tasktracking.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends CrudDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    Long getKey(User entity) {
        return entity.getId();
    }

}
