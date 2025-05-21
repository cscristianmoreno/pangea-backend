package com.backend.pangea.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.pangea.annotations.JPARepository;
import com.backend.pangea.entity.Administrators;
import com.backend.pangea.models.ICrudRepository;

@JPARepository
public interface AdministratorRepository extends ICrudRepository<Administrators>, CrudRepository<Administrators, Integer> {
    
}
