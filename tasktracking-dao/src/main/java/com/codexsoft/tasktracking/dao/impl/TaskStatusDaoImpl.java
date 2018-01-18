package com.codexsoft.tasktracking.dao.impl;

import com.codexsoft.tasktracking.dao.TaskStatusDao;
import com.codexsoft.tasktracking.entity.TaskStatus;
import org.springframework.stereotype.Repository;

@Repository
public class TaskStatusDaoImpl extends CrudDaoImpl<TaskStatus, Long> implements TaskStatusDao {

    public TaskStatusDaoImpl() {
        super(TaskStatus.class);
    }

    @Override
    Long getKey(TaskStatus entity) {
        return entity.getId();
    }

}
