package lk.ijse.greenshadow_backend.controller;

import lk.ijse.greenshadow_backend.dto.FieldStatus;
import lk.ijse.greenshadow_backend.dto.impl.CropDTO;
import lk.ijse.greenshadow_backend.dto.impl.FieldDTO;
import lk.ijse.greenshadow_backend.exception.DataPersistException;
import lk.ijse.greenshadow_backend.service.FieldService;
import lk.ijse.greenshadow_backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/fields")
@CrossOrigin
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("name") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extentSize") String extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2,
//            @RequestPart("staffList") List<StaffDTO> staffList,
            @RequestPart("cropList") List<CropDTO> cropList
    ) {
        try {
            var fieldDTO = new FieldDTO();
            fieldDTO.setName(fieldName);
            fieldDTO.setLocation(location);
            fieldDTO.setExtentSize(Double.parseDouble(extentSize));
            fieldDTO.setFieldImage1(AppUtil.imageBase64(fieldImage1.getBytes()));
            fieldDTO.setFieldImage2(AppUtil.imageBase64(fieldImage2.getBytes()));
//            fieldDTO.setStaffList(staffList);
            fieldDTO.setCropList(cropList);
            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{fieldId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable("fieldId") String fieldId){
        return fieldService.getSelectedField(fieldId);
    }

    @GetMapping
    public List<FieldDTO> getAllField(){
        try {
            return fieldService.getAllField();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @DeleteMapping(value = "/{fieldId}")
    public ResponseEntity<Void> deleteField(@PathVariable ("fieldId") String fieldId){
        return null;
    }

    @PutMapping(value = "/{fieldId}")
    public void updateField(@PathVariable("fieldId") String fieldId) throws IOException {

    }
}