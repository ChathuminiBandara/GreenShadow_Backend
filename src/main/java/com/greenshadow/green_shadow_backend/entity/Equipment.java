package com.greenshadow.green_shadow_backend.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "equipment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String equipmentType;

    @NotBlank
    private String serialNumber;

    private String status; // e.g., Available, In Use, Maintenance
}
