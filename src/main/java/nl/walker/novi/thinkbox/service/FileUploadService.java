//package nl.walker.novi.thinkbox.service;
//import nl.walker.novi.thinkbox.domain.Upload;
//import java.util.List;
//
//public interface FileUploadService {
//
//    List<Upload> getAllUploads();
//    Upload getUploadById(long id);
//    void deleteUpload(long id);
////    long saveUpload(Upload);
//    void updateUpload(long id, Upload upload );
//}


package nl.walker.novi.thinkbox.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public static String uploadDirectory = System.getProperty("user.dir") + "/fileUploads/";

    public void uploadFile(MultipartFile file ) throws IOException {
        file.transferTo(new File(uploadDirectory + file.getOriginalFilename() ));
    }
}