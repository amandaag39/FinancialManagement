package org.example.dao;

import java.util.List;

public interface GenericDAO<T> {
    void create(T entity);
    T getById(int id);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
}
