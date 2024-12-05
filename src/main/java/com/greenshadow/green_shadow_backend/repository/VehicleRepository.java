package com.greenshadow.green_shadow_backend.repository;

import com.greenshadow.green_shadow_backend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
