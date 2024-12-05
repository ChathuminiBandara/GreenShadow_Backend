package com.greenshadow.green_shadow_backend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String vehicleType;

    @NotBlank
    private String licensePlate;

    private String status; // e.g., Available, In Use, Maintenance
}
