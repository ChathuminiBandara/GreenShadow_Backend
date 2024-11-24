package demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.LogEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.CropService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CropServiceIMPL implements CropService {

    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private FieldDao fieldDao;


    @Override
    public void saveCrop(CropDTO cropDTO) {
        int number =0;
        CropEntity crop =cropDao.findLastRowNative();
        if (crop != null) {
            String[] parts = crop.getCropCode().split("-");
            number = Integer.parseInt(parts[1]);
        }
            cropDTO.setCropCode("CROP-"+ ++number);
            CropEntity cropEntity =mapping.toCropEntity(cropDTO);
            List<FieldEntity>fieldEntities =new ArrayList<>();
                for (String fieldCode: cropDTO.getFieldList()){
                    if (fieldDao.existsById(fieldCode)){
                        fieldEntities.add(fieldDao.getReferenceById(fieldCode));
                    }
                }
            cropEntity.setFieldList(fieldEntities);
                for (FieldEntity fieldEntity:fieldEntities){
                    fieldEntity.getCropList().add(cropEntity);
                }

                cropDao.save(cropEntity);
                if (cropEntity==null){
                    throw new DataPersistException("Crop ID not found!");
                }
    }

    @Override
    public List<CropDTO> getAllCrops() {
        List<CropDTO>cropDTOS =new ArrayList<>();
        for (CropEntity crop: cropDao.findAll()){
            List<String>fieldCodes =new ArrayList<>();

            for (FieldEntity fieldEntity:crop.getFieldList()){
                fieldCodes.add(fieldEntity.getFieldCode());
            }

            CropDTO cropDTO =mapping.asCropDtolist(crop);

            cropDTO.setFieldList(fieldCodes);
            cropDTOS.add(cropDTO);

        }
        return cropDTOS;
    }

    @Override
    public CropDTO getCrop(String cropCode) {

            CropEntity selectCrop = cropDao.getReferenceById(cropCode);
            return mapping.toCropDto(selectCrop);
        }


    @Override
    public void deleteCrop(String cropCode) {
        if (cropDao.existsById(cropCode)){
            CropEntity crop =cropDao.getReferenceById(cropCode);
            List<FieldEntity>fieldEntities=crop.getFieldList();
            for (FieldEntity field:fieldEntities){
                List<CropEntity>cropEntities =field.getCropList();
                    cropEntities.remove(crop);
            }
            List<LogEntity>logEntities=crop.getLogList();
            for (LogEntity log:logEntities){
                List<CropEntity> cropEntities=log.getCropList();
                cropEntities.remove(log);
            }

            crop.getFieldList().clear();
            cropDao.delete(crop);
        }else {
            throw new NotFoundException("You entered crop ID not found");
        }

    }

    @Override
    public void updateCrop(String cropCode, CropDTO cropDTO) {
        Optional<CropEntity> cropEntity = cropDao.findById(cropCode);
        if (cropEntity.isPresent()){
            cropEntity.get().setCropName(cropDTO.getCropName());
            cropEntity.get().setScientificName(cropDTO.getScientificName());
            cropEntity.get().setSeason(cropDTO.getSeason());
            cropEntity.get().setCategory(cropDTO.getCategory());
            cropEntity.get().setCropImage(cropDTO.getCropImage());
        }
    }
}
