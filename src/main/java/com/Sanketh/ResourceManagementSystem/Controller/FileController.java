package com.Sanketh.ResourceManagementSystem.Controller;

import com.Sanketh.ResourceManagementSystem.Entity.Filemodul;
import com.Sanketh.ResourceManagementSystem.Service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/add")
    public String addFile(@RequestParam("file") MultipartFile file) {
        fileService.addFile(file);

    }
    @
    @GetMapping("")
    public ResponseEntity<String> getFile("get/{id}") {


    }

}
