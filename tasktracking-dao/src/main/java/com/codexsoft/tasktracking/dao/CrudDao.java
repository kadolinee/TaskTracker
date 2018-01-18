package com.codexsoft.tasktracking.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudDao<T, K extends Serializable> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T find(K key);

    List<T> findAll();
}
