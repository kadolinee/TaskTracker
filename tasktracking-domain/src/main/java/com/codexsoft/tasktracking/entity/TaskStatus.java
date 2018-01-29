package com.codexsoft.tasktracking.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task_status")
public class TaskStatus {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
