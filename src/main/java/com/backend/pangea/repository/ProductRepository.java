package com.backend.pangea.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.pangea.annotations.JPARepository;
import com.backend.pangea.entity.Products;
import com.backend.pangea.models.ICrudRepository;

@JPARepository
public interface ProductRepository extends ICrudRepository<Products>, CrudRepository<Products, Integer> {
    
}
