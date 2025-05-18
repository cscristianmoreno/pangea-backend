package com.backend.pangea.security;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.backend.pangea.annotations.TestInitializer;
import com.backend.pangea.mock.CredentialMock;

@TestInitializer
public class CustomAuthenticationManagerTest {

    @MockitoBean
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;

    private Authentication usernamePasswordAuthenticationToken; 

    @BeforeEach
    void setup() {
        usernamePasswordAuthenticationToken = CredentialMock.getCredential("user");
    }

    @Test
    void testAuthenticate() {
        given(customAuthenticationManager.authenticate(usernamePasswordAuthenticationToken)).willReturn(usernamePasswordAuthenticationToken);

        Authentication authentication = customAuthenticationManager.authenticate(usernamePasswordAuthenticationToken);
        assertNotNull(authentication);
    }
}
