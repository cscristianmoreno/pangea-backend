package com.backend.pangea.models;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    T save(T entity);

    T update(T entity);

    Optional<T> findById(int id);
    
    List<T> findAll();

    void deleteById(int id);
}
