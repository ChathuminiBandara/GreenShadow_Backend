package com.greenshadow.green_shadow_backend.service;


import com.greenshadow.green_shadow_backend.entity.Crop;
import com.greenshadow.green_shadow_backend.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<Crop> getAllCrops(String sortBy) {
        if (sortBy != null) {
            return cropRepository.findAll(Sort.by(sortBy));
        }
        return cropRepository.findAll();
    }

    public Optional<Crop> getCropById(Long id) {
        return cropRepository.findById(id);
    }

    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public Crop updateCrop(Long id, Crop cropDetails) {
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found"));

        crop.setCropName(cropDetails.getCropName());
        crop.setPlantingDate(cropDetails.getPlantingDate());
        crop.setHarvestDate(cropDetails.getHarvestDate());
        crop.setField(cropDetails.getField());
        // Update other fields as necessary

        return cropRepository.save(crop);
    }

    public void deleteCrop(Long id) {
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found"));
        cropRepository.delete(crop);
    }
}
