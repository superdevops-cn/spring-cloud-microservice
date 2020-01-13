package com.sugelamei.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(fileToSave));
        return fileToSave.getAbsolutePath();
    }
}
