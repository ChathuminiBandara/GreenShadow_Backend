package com.greenshadow.green_shadow_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "fields")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    private double landSize; // in acres or relevant unit

    // Spatial data can be represented using coordinates or geometrical data types
    private String location; // Simplified for this example

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private Set<Crop> crops;
}
