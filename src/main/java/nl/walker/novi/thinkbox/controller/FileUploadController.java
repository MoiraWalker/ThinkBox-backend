//package nl.walker.novi.thinkbox.controller;
//import nl.walker.novi.thinkbox.domain.Upload;
//import nl.walker.novi.thinkbox.service.FileUploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
//public class FileUploadController {
//    @Autowired
//    FileUploadService fileUploadService;
//
//    @PostMapping("/uploads")
//    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
//        fileUploadService.uploadFile(file);
//    }
//
//    @GetMapping(value = "/uploads")
//    public ResponseEntity<Object> getAllUploads() {
//        List<Upload> uploads = FileUploadService.getAllUploads();
//        return new ResponseEntity<>(uploads, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/uploads/{id}")
//    public ResponseEntity<Object> getUploadsById(@PathVariable("id") long id) {
//        Upload upload = fileUploadService.getUploadById(id);
//        return new ResponseEntity<>(upload, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/uploads/{id}")
//    public ResponseEntity<Object> deleteUpload(@PathVariable("id") long id) {
//        FileUploadService.deleteUpload(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
////    @PostMapping(value = "/uploads")
////    public ResponseEntity<Object> saveUpload(@RequestBody Upload upload) {
////        long newId = fileUploadService.saveUpload(upload);
////        return new ResponseEntity<>(newId, HttpStatus.CREATED);
////    }
//
//    @PutMapping(value = "/uploads/{id}")
//    public ResponseEntity<Object> updateUpload(@PathVariable("id") int id, @RequestBody Upload upload) {
//        fileUploadService.updateUpload(id, upload);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}


package nl.walker.novi.thinkbox.controller;

import nl.walker.novi.thinkbox.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/uploads")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        fileUploadService.uploadFile(file);
    }
}