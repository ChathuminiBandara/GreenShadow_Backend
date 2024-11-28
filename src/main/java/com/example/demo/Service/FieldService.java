package com.example.demo.Service;

import com.example.demo.DTO.FieldStatus;
import com.example.demo.DTO.IMPL.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    List<FieldDTO>getAllFields();
    FieldStatus getField(String fieldCode);
    void deleteFields(String fieldCode);
    void updateField(String fieldCode, FieldDTO fieldDTO);

}
