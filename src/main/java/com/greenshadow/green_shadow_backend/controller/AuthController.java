package com.greenshadow.green_shadow_backend.controller;



import com.greenshadow.green_shadow_backend.dto.JwtResponse;
import com.greenshadow.green_shadow_backend.dto.LoginRequest;
import com.greenshadow.green_shadow_backend.dto.MessageResponse;
import com.greenshadow.green_shadow_backend.dto.SignupRequest;
import com.greenshadow.green_shadow_backend.entity.User;
import com.greenshadow.green_shadow_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        String token = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(new JwtResponse(token, "Bearer"));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        User user = authService.registerUser(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getRole());

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
