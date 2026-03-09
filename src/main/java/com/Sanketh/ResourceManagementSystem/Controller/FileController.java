package com.Sanketh.ResourceManagementSystem.Controller;

import com.Sanketh.ResourceManagementSystem.Entity.Filemodul;
import com.Sanketh.ResourceManagementSystem.Service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<Filemodul> addFile(@RequestParam("file") MultipartFile file) {
      return new ResponseEntity<>(fileService.addFile(file), HttpStatus.OK);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<byte []> getFile(@PathVariable int id) {
        Filemodul filemodul = fileService.getFile(id);
       return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(filemodul.getFiletype()))
                .body(filemodul.getContent());

    }

}
