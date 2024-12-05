package com.greenshadow.green_shadow_backend.repository;

import com.greenshadow.green_shadow_backend.entity.ERole;
import com.greenshadow.green_shadow_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
