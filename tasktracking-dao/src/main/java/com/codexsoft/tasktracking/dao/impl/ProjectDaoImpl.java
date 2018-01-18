package com.codexsoft.tasktracking.dao.impl;

import com.codexsoft.tasktracking.dao.ProjectDao;
import com.codexsoft.tasktracking.entity.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoImpl extends CrudDaoImpl<Project, Long> implements ProjectDao {

    public ProjectDaoImpl() {
        super(Project.class);
    }

    @Override
    Long getKey(Project entity) {
        return entity.getId();
    }

}
