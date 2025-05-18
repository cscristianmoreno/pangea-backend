package com.backend.pangea.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.pangea.annotations.JPARepository;

import jakarta.transaction.Transactional;

public interface ICrudRepository<T> {
    Optional<T> findById(int id);

    List<T> findAll();

    @Transactional
    void deleteById(int id);
}
