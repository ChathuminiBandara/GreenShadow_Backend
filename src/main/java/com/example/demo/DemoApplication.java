package com.example.demo;

import com.example.demo.DAO.RoleRepository;
import com.example.demo.util.Enum.Roles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository) {
        return args -> {
            for (Roles role : Roles.values()) {
                if (!roleRepository.findByName(role).isPresent()) {
                    roleRepository.save(new com.example.demo.Entity.Role(null, role));
                }
            }
        };
    }
}
