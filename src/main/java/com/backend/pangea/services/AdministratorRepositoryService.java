package com.backend.pangea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Administrators;
import com.backend.pangea.models.services.IAdministratorRepositoryService;
import com.backend.pangea.repository.AdministratorRepository;

@Service
public class AdministratorRepositoryService implements IAdministratorRepositoryService {

    private final AdministratorRepository administaroRepository;

    public AdministratorRepositoryService(final AdministratorRepository administaroRepository) {
        this.administaroRepository = administaroRepository;
    }

    @Override
    public Administrators save(Administrators entity) {
        return administaroRepository.save(entity);
    }

    @Override
    public Administrators update(Administrators entity) {
        return administaroRepository.save(entity);
    }

    @Override
    public Optional<Administrators> findById(int id) {
        return administaroRepository.findById(id);
    }

    @Override
    public List<Administrators> findAll() {
        return administaroRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        administaroRepository.deleteById(id);
    }
    
}
