package com.codexsoft.tasktracking.dao.impl;

import com.codexsoft.tasktracking.dao.CrudDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class CrudDaoImpl<T, K extends Serializable> implements CrudDao<T, K> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> type;

    private CrudDaoImpl() {
    }

    public CrudDaoImpl(Class<T> type) {
        this.type = type;
    }

    EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        if (!entityManager.contains(entity)) {
            entity = find(getKey(entity));
        }
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public T find(K key) {
        return entityManager.find(type, key);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("select t from " + type.getSimpleName() + " t ORDER BY t.id ASC", type).getResultList();
    }

    abstract K getKey(T entity);


}
