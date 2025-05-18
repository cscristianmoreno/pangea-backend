package com.backend.pangea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Consumers;
import com.backend.pangea.models.IRepository;
import com.backend.pangea.repository.ConsumerRepository;

@Service
public class ConsumerRepositoryService implements IRepository<Consumers> {

    private final ConsumerRepository consumerRepository;

    public ConsumerRepositoryService(final ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @Override
    public Consumers save(Consumers entity) {
        return consumerRepository.save(entity);
    }

    @Override
    public Consumers update(Consumers entity) {
        return consumerRepository.save(entity);
    }

    @Override
    public Optional<Consumers> findById(int id) {
        return consumerRepository.findById(id);
    }

    @Override
    public List<Consumers> findAll() {
        return consumerRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        consumerRepository.deleteById(id);
    }
    
}
