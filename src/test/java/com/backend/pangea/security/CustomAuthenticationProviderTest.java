package com.backend.pangea.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.backend.pangea.annotations.TestInitializer;
import com.backend.pangea.entity.Users;
import com.backend.pangea.mock.CredentialMock;
import com.backend.pangea.mock.UserMock;
import com.backend.pangea.services.UserRepositoryService;

@TestInitializer
public class CustomAuthenticationProviderTest {

    @MockitoBean
    private UserRepositoryService userRepositoryService;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;
    

    private Users user;
    private Authentication credentials;

    @BeforeEach
    void setup() {
        user = UserMock.getUser();

        given(userRepositoryService.findByEmail(user.getEmail())).willReturn(Optional.of(user));
    }

    @Test
    void testAuthenticateSuccess() {
        credentials = CredentialMock.getCredential("user");
        Authentication authentication = customAuthenticationProvider.authenticate(credentials);

        assertNotNull(authentication);
        assertEquals(authentication.getName(), user.getEmail());
    }

    @Test
    void testAuthenticatePasswordFailed() {
        credentials = CredentialMock.getCredential("not-match");
        assertThrows(BadCredentialsException.class, () -> {
            customAuthenticationProvider.authenticate(credentials);
        });
    }
}
