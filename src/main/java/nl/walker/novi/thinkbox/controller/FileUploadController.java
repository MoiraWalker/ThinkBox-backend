package nl.walker.novi.thinkbox.controller;

import nl.walker.novi.thinkbox.domain.FileUpload;
import nl.walker.novi.thinkbox.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.Optional;

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

//    @GetMapping("/uploads/{fileName}")
//    public Resource download(@PathVariable String fileName) {
//        Path pathToFile = Path.of("./fileUploads/" + fileName);
//
//        UrlResource resource = null;
//        try {
//            resource = new UrlResource(pathToFile.toUri());
//        } catch (MalformedURLException e){
//            throw new RuntimeException(e);
//        }
//        return resource;
//
//    }


//    @GetMapping(value = "/uploads/{id}")
//    public ResponseEntity<Object> getFileUploadById(@PathVariable("id") long id) {
//        FileUpload fileUpload = fileUploadService.getFileUploadById(id);
//        return new ResponseEntity<>(fileUpload, HttpStatus.OK);
//    }

//    //    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @DeleteMapping(value = "/uploads/{id}")
//    public ResponseEntity<Object> deleteFileUpload(@PathVariable("id") long id) {
//        fileUploadService.deleteFileUpload(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    //    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @PostMapping(value = "/uploads")
//    public ResponseEntity<Object> saveFileUpload(@RequestBody FileUpload fileUpload) {
//        long newId = fileUploadService.saveFileUpload(fileUpload);
//        return new ResponseEntity<>(newId, HttpStatus.CREATED);
//    }
//
//    //    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @PutMapping(value = "/uploads/{id}")
//    public ResponseEntity<Object> updateFileUpload(@PathVariable("id") int id, @RequestBody FileUpload fileUpload) {
//        fileUploadService.updateFileUpload(id, fileUpload);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//

}