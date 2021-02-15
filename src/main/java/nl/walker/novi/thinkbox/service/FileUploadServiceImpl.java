//package nl.walker.novi.thinkbox.service;
//import nl.walker.novi.thinkbox.domain.Upload;
//import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
//import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
//import nl.walker.novi.thinkbox.repository.FileUploadRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class FileUploadServiceImpl implements FileUploadService {
//
//    @Autowired
//    private FileUploadRepository fileUploadRepository;
//
//    public static String uploadDirectory = System.getProperty("user.dir") + "/fileUploads/";
//
//    public void uploadFile(MultipartFile file ) throws IOException {
//        file.transferTo(new File(uploadDirectory + file.getOriginalFilename() ));
//    }
//
//    @Override
//    public List<Upload> getAllUploads() {
//        return fileUploadRepository.findAll();
//    }
//
//    @Override
//    public Upload getUploadById(long id) {
//        if (fileUploadRepository.existsById(id)) {
//            return fileUploadRepository.findById(id).orElse(null);
//        }
//        else {
//            throw new RecordNotFoundException();
//        }
//    }
//
//    @Override
//    public void deleteUpload(long id) {
//        if (fileUploadRepository.existsById(id)) {
//            fileUploadRepository.deleteById(id);
//        }
//        else {
//            throw new RecordNotFoundException();
//        }
//    }
//
////    @Override
////    public long saveUpload(Upload upload) {
////        Upload newUpload = fileUploadRepository.save(upload);
////        return newUpload.getId();
////    }
//
//    @Override
//    public void updateUpload(long id, Upload upload) {
//        if (fileUploadRepository.existsById(id)) {
//            try {
//                Upload existingUpload = fileUploadRepository.findById(id).orElse(null);
//                existingUpload.setTitle(upload.getTitle());
//                existingUpload.setFile(upload.getFile());
//                fileUploadRepository.save(existingUpload);
//            }
//            catch (Exception ex) {
//                throw new DatabaseErrorException();
//            }
//        }
//        else {
//            throw new RecordNotFoundException();
//        }
//    }
//}
