package com.greenshadow.green_shadow_backend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "crops")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String cropName;

    private LocalDate plantingDate;

    private LocalDate harvestDate;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;

    // Additional attributes like crop health, etc., can be added here
}
