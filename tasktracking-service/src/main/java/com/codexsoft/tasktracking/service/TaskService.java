package com.codexsoft.tasktracking.service;

import com.codexsoft.tasktracking.entity.Task;

public interface TaskService extends CrudService<Task, Long> {

    Task updateStatus(long taskId, long taskStatusId);
}
