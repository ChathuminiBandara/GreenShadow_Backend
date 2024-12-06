package com.example.demo.Entity;

import com.example.demo.util.Enum.FuelType;
import com.example.demo.util.Enum.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String licensePlate;

    @NotBlank
    private String vehicleCategory;

    private String fuelType;

    private FuelType type;

    private Status status;

    @ManyToMany
    @JoinTable(name = "vehical_staff",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private Set<Staff> staffs;

    @ManyToMany
    @JoinTable(name = "vehical_field",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "field_id"))
    private Set<Field> fields;
}
