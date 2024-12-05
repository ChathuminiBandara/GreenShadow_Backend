package com.greenshadow.green_shadow_backend.repository;

import com.greenshadow.green_shadow_backend.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
