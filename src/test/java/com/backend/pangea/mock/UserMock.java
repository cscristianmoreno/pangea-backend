package com.backend.pangea.mock;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.backend.pangea.entity.Users;
import com.backend.pangea.enums.UserRole;

public abstract class UserMock {
    
    public static Users getUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Users user = new Users();
        user.setName("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setPhone("3871234567");
        user.setEmail("example@gmail.com");
        user.setBuyerDirection("San Lorenzo");
        user.setSellerDirection("San Lorenzo");
        user.setMemberState("-");
        
        return user;
    }
}
