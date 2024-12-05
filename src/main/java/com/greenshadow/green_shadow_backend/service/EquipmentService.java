package com.greenshadow.green_shadow_backend.service;


import com.greenshadow.green_shadow_backend.entity.Equipment;
import com.greenshadow.green_shadow_backend.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getAllEquipment(String sortBy) {
        if (sortBy != null) {
            return equipmentRepository.findAll(Sort.by(sortBy));
        }
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentRepository.findById(id);
    }

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Long id, Equipment equipmentDetails) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        equipment.setEquipmentType(equipmentDetails.getEquipmentType());
        equipment.setSerialNumber(equipmentDetails.getSerialNumber());
        equipment.setStatus(equipmentDetails.getStatus());
        // Update other fields as necessary

        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        equipmentRepository.delete(equipment);
    }
}
