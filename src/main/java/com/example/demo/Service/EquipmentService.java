package com.example.demo.Service;

import com.example.demo.DAO.EquipmentRepository;
import com.example.demo.Entity.Equipment;
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

        equipment.setName(equipmentDetails.getName());
        equipment.setEquipmentType(equipmentDetails.getEquipmentType());
        equipment.setStatus(equipmentDetails.getStatus());
        equipment.setFields(equipmentDetails.getFields());
        equipment.setStaffs(equipmentDetails.getStaffs());

        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        equipmentRepository.delete(equipment);
    }
}
