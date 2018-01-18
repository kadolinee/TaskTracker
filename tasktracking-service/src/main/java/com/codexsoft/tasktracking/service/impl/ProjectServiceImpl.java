package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.ProjectDao;
import com.codexsoft.tasktracking.entity.Project;
import com.codexsoft.tasktracking.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends CrudServiceImpl<Project, Long> implements ProjectService {

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        super(projectDao);
    }
}
