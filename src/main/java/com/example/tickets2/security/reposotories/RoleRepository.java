package com.example.tickets2.security.reposotories;

import com.example.tickets2.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, String> {
    Role findByRole(String role);
}
