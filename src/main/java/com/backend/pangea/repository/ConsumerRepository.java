package com.backend.pangea.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.pangea.annotations.JPARepository;
import com.backend.pangea.entity.Consumers;
import com.backend.pangea.entity.Users;
import com.backend.pangea.models.ICrudRepository;

@JPARepository
public interface ConsumerRepository extends ICrudRepository<Consumers>, CrudRepository<Consumers, Integer> {
    
}
