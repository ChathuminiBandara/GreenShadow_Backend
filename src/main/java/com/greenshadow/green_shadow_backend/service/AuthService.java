package com.greenshadow.green_shadow_backend.service;



import com.greenshadow.green_shadow_backend.entity.ERole;
import com.greenshadow.green_shadow_backend.entity.Role;
import com.greenshadow.green_shadow_backend.entity.User;
import com.greenshadow.green_shadow_backend.repository.RoleRepository;
import com.greenshadow.green_shadow_backend.repository.UserRepository;
import com.greenshadow.green_shadow_backend.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public String authenticateUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateJwtToken(authentication);
    }

    public User registerUser(String username, String email, String password, Set<String> strRoles) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));

        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.OTHER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch(role.toUpperCase()) {
                    case "MANAGER":
                        Role managerRole = roleRepository.findByName(ERole.MANAGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(managerRole);
                        break;
                    case "ADMINISTRATIVE":
                        Role adminRole = roleRepository.findByName(ERole.ADMINISTRATIVE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "SCIENTIST":
                        Role scientistRole = roleRepository.findByName(ERole.SCIENTIST)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(scientistRole);
                        break;
                    default:
                        Role otherRole = roleRepository.findByName(ERole.OTHER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(otherRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return user;
    }
}
