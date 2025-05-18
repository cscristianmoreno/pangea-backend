package com.backend.pangea.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return (
            httpSecurity
                .authorizeHttpRequests((req) -> {
                    req.anyRequest().permitAll();
                })
                .csrf((csrf) -> {
                    csrf.disable();
                })
                .formLogin((form) -> form.disable())
                .httpBasic(Customizer.withDefaults())
            .build()
        );
    }
}
