package com.example.tickets2.security.services;

import com.example.tickets2.security.entities.Role;
import com.example.tickets2.security.entities.User;
import com.example.tickets2.security.reposotories.RoleRepository;
import com.example.tickets2.security.reposotories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements  AccountService{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public User createUser(String username, String password, String email, String confirmPassword) {
        /*User user1 = new User();
        user1.setUserId(UUID.randomUUID().toString());
        user1.setUsername(username);
        user1.setPassword(bCryptPasswordEncoder.encode(password));
        user1.setEmail(email);
        userRepository.save(user1);

        */
        User user1 = userRepository.findByUsername(username);
        if (user1 != null ) throw new RuntimeException("User already exists");
        if(!password.equals(confirmPassword)) throw  new RuntimeException("Password do not match");
                user1= User.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .email(email)
                .build();
        return userRepository.save(user1);
    }

    @Override
    public Role creatRole(String newRole) {
        Role role1 = roleRepository.findByRole(newRole);
                role1 = Role.builder()
                .role(newRole)
                .build();
        return roleRepository.save(role1);

    }

    @Override
    public void addRoleToUser(String username, String newRole) {
        User user1 = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByRole(newRole);
        user1.getRoles().add(role1);

    }

    @Override
    public void removeRoleFromUser(String username, String newRole) {
        User user1 = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByRole(newRole);
        user1.getRoles().remove(role1);


    }

    @Override
    public User loadUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
