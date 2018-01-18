package com.codexsoft.tasktracking.dao.impl;

import com.codexsoft.tasktracking.dao.RoleDao;
import com.codexsoft.tasktracking.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends CrudDaoImpl<Role, Long> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    Long getKey(Role entity) {
        return entity.getId();
    }

}
