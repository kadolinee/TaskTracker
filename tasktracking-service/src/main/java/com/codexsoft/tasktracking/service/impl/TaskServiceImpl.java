package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.TaskDao;
import com.codexsoft.tasktracking.entity.Task;
import com.codexsoft.tasktracking.entity.TaskStatus;
import com.codexsoft.tasktracking.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl extends CrudServiceImpl<Task, Long> implements TaskService {

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        super(taskDao);
    }

    @Transactional
    @Override
    public Task updateStatus(long taskId, long taskStatusId) {
        Task task = getDao().find(taskId);
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setId(taskStatusId);
        task.setTaskStatus(taskStatus);
        getDao().update(task);
        return task;
    }
}
