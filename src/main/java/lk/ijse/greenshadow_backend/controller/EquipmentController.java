package lk.ijse.greenshadow_backend.controller;


import lk.ijse.greenshadow_backend.dto.EquipmentStatus;
import lk.ijse.greenshadow_backend.dto.impl.EquipmentDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipment")
public class EquipmentController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(@RequestBody EquipmentDTO equipmentDTO){
        return null;
    }

    @GetMapping(value = "/{equipmentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipmentStatus getSelectedEquipment(@PathVariable("equipmentId") String equipmentId){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDTO> getAllEquipment(){
        return null;
    }

    @DeleteMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable ("equipmentId") String equipmentId){
        return null;
    }

    @PutMapping(value = "/{equipmentId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEquipment(@PathVariable ("equipmentId") String equipmentId ,@RequestBody EquipmentDTO equipmentDTO){
        return null;
    }
}