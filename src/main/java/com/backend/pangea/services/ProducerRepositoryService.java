package com.backend.pangea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Producers;
import com.backend.pangea.models.services.IProducerRepositoryService;
import com.backend.pangea.repository.ProducerRepository;

@Service
public class ProducerRepositoryService implements IProducerRepositoryService {
    private final ProducerRepository producerRepository;

    public ProducerRepositoryService(final ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public Producers save(Producers entity) {
        return producerRepository.save(entity);
    }

    @Override
    public Producers update(Producers entity) {
        return producerRepository.save(entity);
    }

    @Override
    public Optional<Producers> findById(int id) {
        return producerRepository.findById(id);
    }

    @Override
    public List<Producers> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        producerRepository.deleteById(id);
    }
}
