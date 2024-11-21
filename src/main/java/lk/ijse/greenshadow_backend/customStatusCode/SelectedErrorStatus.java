package lk.ijse.greenshadow_backend.customStatusCode;

import lk.ijse.greenshadow_backend.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements CropStatus, EquipmentStatus, FieldStatus, LogStatus, StaffEquipmentDetailsStatus,StaffStatus,UserStatus,VehicleStatus {
    private Integer status;
    private String statusMessage;
}
