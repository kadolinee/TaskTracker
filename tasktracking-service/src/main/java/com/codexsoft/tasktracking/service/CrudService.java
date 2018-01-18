package com.codexsoft.tasktracking.service;

import java.io.Serializable;
import java.util.List;

public interface CrudService<T, K extends Serializable> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T find(K key);

    List<T> findAll();
}
