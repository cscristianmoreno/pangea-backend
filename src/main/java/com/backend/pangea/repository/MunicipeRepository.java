package com.backend.pangea.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.pangea.annotations.JPARepository;
import com.backend.pangea.entity.Municipes;
import com.backend.pangea.models.ICrudRepository;

@JPARepository
public interface MunicipeRepository extends ICrudRepository<Municipes>, CrudRepository<Municipes, Integer> {
    
}
