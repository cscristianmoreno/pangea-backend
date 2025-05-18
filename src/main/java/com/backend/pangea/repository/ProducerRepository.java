package com.backend.pangea.repository;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.pangea.annotations.JPARepository;
import com.backend.pangea.entity.Producers;
import com.backend.pangea.models.ICrudRepository;

@JPARepository
public interface ProducerRepository extends ICrudRepository<Producers>, CrudRepository<Producers, Integer> {
    
}
