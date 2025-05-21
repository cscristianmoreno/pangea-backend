package com.backend.pangea.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.backend.pangea.annotations.TestInitializer;
import com.backend.pangea.entity.Administrators;
import com.backend.pangea.entity.Users;
import com.backend.pangea.mock.UserMock;
import com.backend.pangea.repository.UserRepository;

@TestInitializer
// @Sql(
//     statements  = "ALTER SEQUENCE users_id_seq RESTART WITH 1"
// )
public class UserRepositoryServiceTest {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Autowired
    private UserRepository userRepository;

    private Users user;

    @BeforeEach
    void setup() {
        user = UserMock.getUser();
        userRepository.deleteAll();
    }

    @Test
    void testSave() {
        Users result = userRepositoryService.save(user);
        System.out.println(result.getPassword());
        assertNotNull(result);
    }

    @Test
    void testUpdate() {
        userRepositoryService.save(user);

        user.setId(1);
        user.setEmail("changed@gmail.com");
        Users resultChanged = userRepositoryService.update(user);

        assertNotNull(resultChanged);
        assertTrue(resultChanged.getEmail().matches("changed@gmail.com"));
    }

    @Test
    void testFindById() {
        Optional<Users> result = userRepositoryService.findById(1);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindAll() {
        List<Users> result = userRepositoryService.findAll();
    }

    @Test
    void testDeleteById() {
    }
}
