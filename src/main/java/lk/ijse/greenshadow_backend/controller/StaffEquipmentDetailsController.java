package lk.ijse.greenshadow_backend.controller;


import lk.ijse.greenshadow_backend.dto.StaffEquipmentDetailsStatus;
import lk.ijse.greenshadow_backend.dto.impl.StaffEquipmentDetailsDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staffEquipment")
public class StaffEquipmentDetailsController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaffEquipment(@RequestBody StaffEquipmentDetailsDTO staffEquipmentDetailsDTO){
        return null;
    }

    @GetMapping(value = "/{staffId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffEquipmentDetailsStatus getSelectedStaffEquipment(@PathVariable("staffId") String staffId){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffEquipmentDetailsDTO> getAllStaffEquipment(){
        return null;
    }

    @DeleteMapping(value = "/{staffId}")
    public ResponseEntity<Void> deleteStaffEquipment(@PathVariable ("staffId") String staffId){
        return null;
    }

    @PutMapping(value = "/{staffId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffEquipment(@PathVariable ("staffId") String staffId ,@RequestBody StaffEquipmentDetailsDTO staffEquipmentDetailsDTO){
        return null;
    }
}