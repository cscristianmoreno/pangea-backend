package com.backend.pangea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Municipes;
import com.backend.pangea.models.services.IMunicipeRepositoryService;
import com.backend.pangea.repository.MunicipeRepository;

@Service
public class MunicipeRepositoryService implements IMunicipeRepositoryService {

    private final MunicipeRepository municipeRepository;

    public MunicipeRepositoryService(final MunicipeRepository municipeRepository) {
        this.municipeRepository = municipeRepository;
    }

    @Override
    public Municipes save(Municipes entity) {
        return municipeRepository.save(entity);
    }

    @Override
    public Municipes update(Municipes entity) {
        return municipeRepository.save(entity);
    }

    @Override
    public Optional<Municipes> findById(int id) {
        return municipeRepository.findById(id);
    }

    @Override
    public List<Municipes> findAll() {
        return municipeRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        municipeRepository.deleteById(id);
    }
    
}
