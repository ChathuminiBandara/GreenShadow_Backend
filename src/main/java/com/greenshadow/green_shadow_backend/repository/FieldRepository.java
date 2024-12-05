package com.greenshadow.green_shadow_backend.repository;

import com.greenshadow.green_shadow_backend.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
