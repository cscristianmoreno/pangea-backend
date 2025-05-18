package com.backend.pangea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Users;
import com.backend.pangea.models.services.IUserRepositoryService;
import com.backend.pangea.repository.UserRepository;

@Service
public class UserRepositoryService implements IUserRepositoryService {
    private final UserRepository userRepository;

    public UserRepositoryService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users save(Users entity) {
        return userRepository.save(entity);
    }

    @Override
    public Users update(Users entity) {
        return userRepository.save(entity);
    }

    @Override
    public Optional<Users> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Users> findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
