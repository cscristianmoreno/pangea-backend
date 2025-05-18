package com.backend.pangea.models.services;

import java.util.Optional;

import com.backend.pangea.entity.Users;
import com.backend.pangea.models.IRepository;

public interface IUserRepositoryService extends IRepository<Users> {
    Optional<Users> findByEmail(String username);
}
