package com.codexsoft.tasktracking.dao.impl;

import com.codexsoft.tasktracking.dao.TaskDao;
import com.codexsoft.tasktracking.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl extends CrudDaoImpl<Task, Long> implements TaskDao {

    public TaskDaoImpl() {
        super(Task.class);
    }

    @Override
    Long getKey(Task entity) {
        return entity.getId();
    }

}
