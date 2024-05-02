package com.example.tickets2.security.services;

import com.example.tickets2.security.entities.Role;
import com.example.tickets2.security.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    User createUser(String username, String password, String email, String confirmPassword);
    Role creatRole(String newRole);
    void addRoleToUser(String username, String newRole);
    void removeRoleFromUser(String username, String newRole);
    User loadUserByUsername(String username);

}
