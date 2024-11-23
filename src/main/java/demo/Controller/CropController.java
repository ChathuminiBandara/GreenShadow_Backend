package demo.Controller;

import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.CropService;
import com.example.demo.util.IdGenerater;
import com.example.demo.util.PicEncorder;
import com.example.demo.util.SplitString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(@RequestPart( "commonName") String cropName,
                                         @RequestPart("scientificName") String scientificName,
                                         @RequestPart("category") String category,
                                         @RequestPart("season") String season,
                                         @RequestPart("cropImage") MultipartFile cropIMg,
                                         @RequestPart("field") String field) {

        try {
            String cropIMG = PicEncorder.generatePicture(cropIMg);
            List<String> filed_codes = new ArrayList<>();


            if (field!= null) {
                filed_codes = SplitString.spiltLists(field);
            }


            CropDTO cropDTO = new CropDTO();
                cropDTO.setCropCode(IdGenerater.generateId("CROP-"));
                cropDTO.setCropName(cropName);
                cropDTO.setScientificName(scientificName);
                cropDTO.setCategory(category);
                cropDTO.setSeason(season);
                cropDTO.setCropImage(cropIMG);
                cropDTO.setFieldList(filed_codes);

            cropService.saveCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{cropCode}")
    public ResponseEntity<Void> deleteCrop(@PathVariable("cropCode")String cropCode){
        try{
            cropService.deleteCrop(cropCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public List<CropDTO>getAllCrops(){
        return cropService.getAllCrops();
    }

    @PutMapping(value = "/{cropCode}")
    public ResponseEntity<Void> updateCrop(@PathVariable("cropCode") String cropId,
                                                @RequestPart( "cropName") String cropName,
                                                @RequestPart("scientificName") String scientificName,
                                                @RequestPart("category") String category,
                                                @RequestPart("season") String season,
                                                @RequestPart("cropImage") MultipartFile cropIMg
//                                                @RequestPart("field") String field
    ) {
        try {
            String cripImage = PicEncorder.generatePicture(cropIMg);
//            List<String> field_code = new ArrayList<>();
//            if (field != null) {
//                field_code = SplitString.spiltLists(field);
//            }
            CropDTO cropDTO = new CropDTO();
            cropDTO.setCropCode(cropId);
            cropDTO.setCropName(cropName);
            cropDTO.setScientificName(scientificName);
            cropDTO.setCategory(category);
            cropDTO.setSeason(season);
            cropDTO.setCropImage(cripImage);
//            cropDTO.setFieldList(field_code);

            cropService.updateCrop(cropId, cropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
