package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.TaskDao;
import com.codexsoft.tasktracking.entity.Task;
import com.codexsoft.tasktracking.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends CrudServiceImpl<Task, Long> implements TaskService {

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        super(taskDao);
    }
}
