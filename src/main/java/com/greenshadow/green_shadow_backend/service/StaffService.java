package com.greenshadow.green_shadow_backend.service;


import com.greenshadow.green_shadow_backend.entity.Staff;
import com.greenshadow.green_shadow_backend.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff(String sortBy) {
        if (sortBy != null) {
            return staffRepository.findAll(Sort.by(sortBy));
        }
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff staffDetails) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staff.setName(staffDetails.getName());
        staff.setDesignation(staffDetails.getDesignation());
        staff.setVehicles(staffDetails.getVehicles());
        staff.setEquipments(staffDetails.getEquipments());
        // Update other fields as necessary

        return staffRepository.save(staff);
    }

    public void deleteStaff(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        staffRepository.delete(staff);
    }
}
