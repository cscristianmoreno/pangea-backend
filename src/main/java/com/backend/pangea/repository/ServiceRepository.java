package com.backend.pangea.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.pangea.annotations.JPARepository;
import com.backend.pangea.entity.Services;
import com.backend.pangea.entity.Users;
import com.backend.pangea.models.ICrudRepository;

@JPARepository
public interface ServiceRepository extends ICrudRepository<Services>, CrudRepository<Services, Integer> {
    
}
