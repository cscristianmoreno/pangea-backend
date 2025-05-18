package com.backend.pangea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Products;
import com.backend.pangea.models.services.IProductRepositoryService;
import com.backend.pangea.repository.ProductRepository;

@Service
public class ProductRepositoryService implements IProductRepositoryService {

    private final ProductRepository productRepository;

    public ProductRepositoryService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Products save(Products entity) {
        return productRepository.save(entity);
    }

    @Override
    public Products update(Products entity) {
        return productRepository.save(entity);
    }

    @Override
    public Optional<Products> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
    
}
