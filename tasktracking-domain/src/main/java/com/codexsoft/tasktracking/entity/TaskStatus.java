package com.codexsoft.tasktracking.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task_status")
public class TaskStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "taskStatus")
    private Task task;

    public TaskStatus() {
    }

    public TaskStatus(String name, Task task) {
        this.name = name;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskStatus that = (TaskStatus) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return task != null ? task.equals(that.task) : that.task == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", task=" + task +
                '}';
    }
}
