package com.backend.pangea.mock;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public abstract class CredentialMock {
    public static UsernamePasswordAuthenticationToken getCredential(final String password) {
        return new UsernamePasswordAuthenticationToken(
            "user",
            password
        );
    }
}
