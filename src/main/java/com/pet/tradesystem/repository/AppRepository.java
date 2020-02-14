package com.pet.tradesystem.repository;

import com.pet.tradesystem.domain.AppEntity;

import java.util.List;

public interface AppRepository<T extends AppEntity, ID> {

    boolean add(T entity);

    T findById(ID primaryKey);

    List<T> findAll();

    boolean update(T entity);

    boolean delete(ID primaryKey);
}
