package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.CrudDao;
import com.codexsoft.tasktracking.service.CrudService;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceImpl<T, K extends Serializable> implements CrudService<T, K> {

    private CrudDao<T, K> dao;

    public CrudServiceImpl(CrudDao<T, K> dao) {
        this.dao = dao;
    }

    CrudDao<T, K> getDao() {
        return dao;
    }

    @Transactional
    @Override
    public void create(T entity) {
        dao.create(entity);
    }

    @Transactional
    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Transactional
    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Transactional
    @Override
    public T find(K key) {
        return dao.find(key);
    }

    @Transactional
    @Override
    public List<T> findAll() {
        return dao.findAll();
    }
}
