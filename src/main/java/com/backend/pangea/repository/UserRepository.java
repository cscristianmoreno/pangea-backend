package com.backend.pangea.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.pangea.annotations.JPARepository;
import com.backend.pangea.entity.Users;
import com.backend.pangea.models.ICrudRepository;

@JPARepository
public interface UserRepository extends ICrudRepository<Users>, CrudRepository<Users, Integer> {
    Optional<Users> findByEmail(String username);
}
