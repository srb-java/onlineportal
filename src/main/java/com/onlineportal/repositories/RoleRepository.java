package com.onlineportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineportal.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

