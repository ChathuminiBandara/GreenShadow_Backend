package com.example.demo.DAO;

import com.example.demo.Entity.Role;
import com.example.demo.util.Enum.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
