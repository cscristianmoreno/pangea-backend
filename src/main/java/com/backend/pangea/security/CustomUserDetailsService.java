package com.backend.pangea.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.pangea.entity.Users;
import com.backend.pangea.services.UserRepositoryService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepositoryService userRepositoryService;

    public CustomUserDetailsService(final UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> result = userRepositoryService.findByEmail(username);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("El usuario no está disponible");
        }

        Users user = result.get();
        return new CustomUserDetails(user);
    }
    
}
