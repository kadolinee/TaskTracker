package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.RoleDao;
import com.codexsoft.tasktracking.entity.Role;
import com.codexsoft.tasktracking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl extends CrudServiceImpl<Role, Long> implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        super(roleDao);
    }

    @Transactional
    public List<Role> get() {
        return getDao().findAll();
    }
}
