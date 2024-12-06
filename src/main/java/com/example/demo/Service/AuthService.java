package com.example.demo.Service;

import com.example.demo.DAO.RoleRepository;
import com.example.demo.DAO.UserRepository;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Security.jwt.JwtUtils;
import com.example.demo.util.Enum.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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
            Role userRole = roleRepository.findByName(Roles.OTHER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch(role.toUpperCase()) {
                    case "MANAGER":
                        Role managerRole = roleRepository.findByName(Roles.MANAGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(managerRole);
                        break;
                    case "ADMINISTRATIVE":
                        Role adminRole = roleRepository.findByName(Roles.ADMINISTRATIVE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "SCIENTIST":
                        Role scientistRole = roleRepository.findByName(Roles.SCIENTIST)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(scientistRole);
                        break;
                    default:
                        Role otherRole = roleRepository.findByName(Roles.OTHER)
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
