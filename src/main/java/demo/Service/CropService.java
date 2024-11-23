package demo.Service;

import com.example.demo.DTO.IMPL.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO>getAllCrops();
    CropDTO getCrop(String cropCode);
    void deleteCrop(String cropCode);
    void updateCrop(String cropCode, CropDTO cropDTO);
}
