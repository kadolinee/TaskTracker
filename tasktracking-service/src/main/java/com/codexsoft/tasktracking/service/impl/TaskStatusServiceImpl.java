package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.TaskStatusDao;
import com.codexsoft.tasktracking.entity.TaskStatus;
import com.codexsoft.tasktracking.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskStatusServiceImpl extends CrudServiceImpl<TaskStatus, Long> implements TaskStatusService {

    @Autowired
    public TaskStatusServiceImpl(TaskStatusDao taskStatusDao) {
        super(taskStatusDao);
    }
}
