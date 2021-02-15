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