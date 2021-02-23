package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.FileUpload;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    public static String uploadDirectory = System.getProperty("user.dir") + "/fileUploads/";

    public void uploadFile(MultipartFile file ) throws IOException {
        file.transferTo(new File(uploadDirectory + file.getOriginalFilename() ));
    }


//
//    public void getFileUploadFromDirectory(String fileName) {
//        Path pathToFile = Path.of(uploadDirectory + fileName);
//    }

//    public List<FileUpload> getAllFileUploads() {
//        return fileUploadRepository.findAll();
//    }
//
//    public FileUpload getFileUploadById(long id) {
//        if (fileUploadRepository.existsById(id)) {
//            return fileUploadRepository.findById(id).orElse(null);
//        }
//        else {
//            throw new RecordNotFoundException();
//        }
//    }
//
//
//    public void deleteFileUpload(long id) {
//        if (fileUploadRepository.existsById(id)) {
//            fileUploadRepository.deleteById(id);
//        }
//        else {
//            throw new RecordNotFoundException();
//        }
//    }
//
//    public long saveFileUpload(FileUpload fileUpload) {
//        FileUpload newFileUpload = fileUploadRepository.save(fileUpload);
//        return newFileUpload.getId();
//    }
//
//    public void updateFileUpload(long id, FileUpload fileUpload) {
//        if (fileUploadRepository.existsById(id)) {
//            try {
//                FileUpload existingFileUpload = fileUploadRepository.findById(id).orElse(null);
//                existingFileUpload.setTitle(fileUpload.getTitle());
//                existingFileUpload.setFileupload(fileUpload.getFileupload());
//                fileUploadRepository.save(existingFileUpload);
//            }
//            catch (Exception ex) {
//                throw new DatabaseErrorException();
//            }
//        }
//        else {
//            throw new RecordNotFoundException();
//        }
//    }
}