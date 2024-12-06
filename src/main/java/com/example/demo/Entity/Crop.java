package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String scientificName;

    @Lob
    @Column(name = "cropImage", columnDefinition = "LONGBLOB") // Adjust columnDefinition based on your DB
    private byte[] cropImage; // Base64 or raw image data as String

    private String category;

    private String season;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;
}
