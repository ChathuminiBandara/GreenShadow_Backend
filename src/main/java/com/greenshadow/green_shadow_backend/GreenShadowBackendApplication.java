package com.greenshadow.green_shadow_backend;
import com.greenshadow.green_shadow_backend.entity.ERole;
import com.greenshadow.green_shadow_backend.entity.Role;
import com.greenshadow.green_shadow_backend.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GreenShadowBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenShadowBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository) {
		return args -> {
			for (ERole role : ERole.values()) {
				if (!roleRepository.findByName(role).isPresent()) {
					roleRepository.save(new Role(null, role));
				}
			}
		};
	}



}
