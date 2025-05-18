package com.backend.pangea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Services;
import com.backend.pangea.models.services.IServiceRepositoryService;
import com.backend.pangea.repository.ServiceRepository;

@Service
public class ServiceRepositoryService implements IServiceRepositoryService {

    private final ServiceRepository serviceRepository;

    public ServiceRepositoryService(final ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Services save(Services entity) {
        return serviceRepository.save(entity);
    }

    @Override
    public Services update(Services entity) {
        return serviceRepository.save(entity);
    }

    @Override
    public Optional<Services> findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        serviceRepository.deleteById(id);
    }
    
}
