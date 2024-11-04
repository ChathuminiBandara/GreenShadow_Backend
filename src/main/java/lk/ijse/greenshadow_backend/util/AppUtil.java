package lk.ijse.greenshadow_backend.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateCropId(){
        return "Crop-"+ UUID.randomUUID();
    }
    public static String generateUserId(){
        return "USER-"+UUID.randomUUID();
    }
    public static String PicToBase64(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
