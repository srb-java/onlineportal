
package com.onlineportal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlineportal.entities.Role;
import com.onlineportal.entities.User;
import com.onlineportal.repositories.RoleRepository;
import com.onlineportal.repositories.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RoleRepository roleRepository;
    
    private static String ROLE_STUDENT = "Student";
    
    public User register(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	
    	// Assign ROLE_STUDENT to new user
        Role role = roleRepository.findByName(ROLE_STUDENT);
        if (role == null) {
            role = new Role(ROLE_STUDENT);
            roleRepository.save(role);
        }
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
    	
        return studentRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}
