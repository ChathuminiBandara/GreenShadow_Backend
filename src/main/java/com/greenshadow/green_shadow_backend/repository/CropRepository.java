package com.greenshadow.green_shadow_backend.repository;

import com.greenshadow.green_shadow_backend.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}
