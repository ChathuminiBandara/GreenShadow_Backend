package com.greenshadow.green_shadow_backend.service;

import com.greenshadow.green_shadow_backend.entity.Field;

import com.greenshadow.green_shadow_backend.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    public List<Field> getAllFields(String sortBy) {
        if (sortBy != null) {
            return fieldRepository.findAll(Sort.by(sortBy));
        }
        return fieldRepository.findAll();
    }

    public Optional<Field> getFieldById(Long id) {
        return fieldRepository.findById(id);
    }

    public Field createField(Field field) {
        return fieldRepository.save(field);
    }

    public Field updateField(Long id, Field fieldDetails) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found"));

        field.setName(fieldDetails.getName());
        field.setLandSize(fieldDetails.getLandSize());
        field.setLocation(fieldDetails.getLocation());
        // Update other fields as necessary

        return fieldRepository.save(field);
    }

    public void deleteField(Long id) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found"));
        fieldRepository.delete(field);
    }
}
