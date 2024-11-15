package lk.ijse.greenshadow_backend.dao;


import lk.ijse.greenshadow_backend.entity.impl.CropEntity;
import lk.ijse.greenshadow_backend.entity.impl.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDAO extends JpaRepository<EquipmentEntity,String> {
}