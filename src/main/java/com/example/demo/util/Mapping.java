package com.example.demo.util;

import com.example.demo.DTO.IMPL.*;
import com.example.demo.Entity.IMPL.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CropEntity toCropEntity(CropDTO cropDTO) {
        CropEntity map = modelMapper.map(cropDTO, CropEntity.class);
             return map;
    }
    public CropDTO toCropDto(CropEntity cropEntity) {

        return modelMapper.map(cropEntity, CropDTO.class);
    }
    public CropDTO asCropDtolist(CropEntity crop){
       CropDTO cropDTO =new CropDTO();
       cropDTO.setCropCode(crop.getCropCode());
       cropDTO.setCropName(cropDTO.getCropName());
       cropDTO.setScientificName(crop.getScientificName());
       cropDTO.setSeason(crop.getSeason());
       cropDTO.setCropImage(crop.getCropImage());
       cropDTO.setFieldList(crop.getFieldList().stream().map(FieldEntity::getFieldCode).toList());
       cropDTO.setLogList(crop.getLogList().stream().map(LogEntity::getLogCode).toList());
    return cropDTO;
    }


    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> asUserDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
    }





    public FieldEntity toFieldEntity(FieldDTO fieldDTO){

        return modelMapper.map(fieldDTO, FieldEntity.class);
    }
    public FieldDTO toFieldDto(FieldEntity fieldEntity){

        return modelMapper.map(fieldEntity, FieldDTO.class);
    }
    public FieldDTO asFieldDtoList(FieldEntity field){
     FieldDTO fieldDTO =new FieldDTO();
        fieldDTO.setFieldCode(field.getFieldCode());
        fieldDTO.setName(field.getName());
        fieldDTO.setLocation(field.getLocation());
        fieldDTO.setExtentSize(field.getExtentSize());
        fieldDTO.setFieldImage1(field.getFieldImage1());
        fieldDTO.setFieldImage2(field.getFieldImage2());
        fieldDTO.setStaffList(field.getStaffList().stream().map(StaffEntity::getMemberCode).toList());
        fieldDTO.setCropsList(field.getCropList().stream().map(CropEntity::getCropCode).toList());
        fieldDTO.setLogsList(field.getLogList().stream().map(LogEntity::getLogCode).toList());
        return fieldDTO;
    }






    public EquipmentEntity toEquipmentEntity(EquipmentDTO equipmentDTO){
        return modelMapper.map(equipmentDTO, EquipmentEntity.class);
    }
    public EquipmentDTO toEquipmentDTO(EquipmentEntity equipmentEntity){
        return modelMapper.map(equipmentEntity, EquipmentDTO.class);
    }
    public EquipmentDTO asEquipmentDtoList(EquipmentEntity equipmentEntity){
        EquipmentDTO equipmentDTO=new EquipmentDTO();
            equipmentDTO.setEquipmentCode(equipmentEntity.getEquipmentCode());
            equipmentDTO.setName(equipmentEntity.getName());
            equipmentDTO.setType(equipmentEntity.getType());
            equipmentDTO.setAvailableCount(equipmentEntity.getAvailableCount());
            equipmentDTO.setFieldList(equipmentEntity.getFieldList().stream().map(FieldEntity::getFieldCode).toList());
    return equipmentDTO;
    }




    public LogEntity toMonitoringLogEntity(MonitoringLogDTO monitoringLogDTO){
        return modelMapper.map(monitoringLogDTO, LogEntity.class);
    }

    public MonitoringLogDTO toMonitoringLogDto(LogEntity monitoringLog){
       return modelMapper.map(monitoringLog, MonitoringLogDTO.class);
    }
    public MonitoringLogDTO asMonitoringDtoList(LogEntity logEntity){
        MonitoringLogDTO mdt=new MonitoringLogDTO();
        mdt.setLogCode(logEntity.getLogCode());
        mdt.setLogDate(logEntity.getDate());
        mdt.setLogDetails(logEntity.getLogDetails());
        mdt.setObservedImage(logEntity.getObservedImage());
        mdt.setStaffList(logEntity.getStaffList().stream().map(StaffEntity::getMemberCode).toList());
        mdt.setCropList(logEntity.getCropList().stream().map(CropEntity::getCropCode).toList());
        mdt.setFieldList(logEntity.getFieldList().stream().map(FieldEntity::getFieldCode).toList());
        return mdt;
    }




    public StaffEntity toStaffEntity(StaffDTO staffDTO){
        return modelMapper.map(staffDTO, StaffEntity.class);
    }
    public StaffDTO toStaffDto(StaffEntity staffEntity){
        return modelMapper.map(staffEntity, StaffDTO.class);
    }
    public StaffDTO asStafDtoList(StaffEntity staffEntity){
        StaffDTO staffDTO =new StaffDTO();
            staffDTO.setMemberCode(staffEntity.getMemberCode());
            staffDTO.setFirstName(staffEntity.getFirstName());
            staffDTO.setLastName(staffEntity.getLastName());
            staffDTO.setJoinedDate(staffEntity.getJoinedDate());
            staffDTO.setDateOfBirth(staffEntity.getDateOfBirth());
            staffDTO.setGender(staffEntity.getGender());
            staffDTO.setDesignation(staffEntity.getDesignation());
            staffDTO.setAddressLine1(staffEntity.getAddressLine1());
            staffDTO.setAddressLine2(staffEntity.getAddressLine2());
            staffDTO.setAddressLine3(staffEntity.getAddressLine3());
            staffDTO.setAddressLine4(staffEntity.getAddressLine4());
            staffDTO.setAddressLine5(staffEntity.getAddressLine5());
            staffDTO.setContactNo(staffEntity.getContactNo());
            staffDTO.setEmail(staffEntity.getEmail());
            staffDTO.setRole(staffEntity.getRole());
            staffDTO.setVehicleList(staffEntity.getVehicleList().stream().map(VehicleEntity::getVehicleCode).toList());
            staffDTO.setFieldList(staffEntity.getFieldList().stream().map(FieldEntity::getFieldCode).toList());
            staffDTO.setLogList(staffEntity.getLogList().stream().map(LogEntity::getLogCode).toList());
    return staffDTO;
    }




    public VehicleEntity toVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }
    public VehicleDTO toVehicleDto(VehicleEntity vehicleEntity){
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
    public List<VehicleDTO>asVehicleDto(List<VehicleEntity>vehicleEntities){
        return modelMapper.map(vehicleEntities,new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
