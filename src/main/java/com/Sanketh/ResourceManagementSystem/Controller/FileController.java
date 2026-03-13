package com.Sanketh.ResourceManagementSystem.Controller;

import com.Sanketh.ResourceManagementSystem.Entity.Filemon;
import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Enums.Roles;
import com.Sanketh.ResourceManagementSystem.Service.FileService;
import com.Sanketh.ResourceManagementSystem.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;
    private final UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Filemon> addFile(@RequestParam("file") MultipartFile file) {
      return new ResponseEntity<>(fileService.addFile(file), HttpStatus.OK);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<byte []> getFile(@PathVariable int id) {
        Filemon filemodul = fileService.getFile(id);
       return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(filemodul.getFiletype()))
                .body(filemodul.getContent());

    }
    @GetMapping("/getall")
    public ResponseEntity<List<Filemon>> getAllFiles() {
        List<Filemon> files = fileService.getAllFile();
        return new ResponseEntity<>(files, HttpStatus.OK);
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {
        Filemon filemodul = fileService.getFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(filemodul.getFiletype()))
                .header("Content-Disposition", "attachment; filename=\"" + filemodul.getFilename() + "\"")
                .body(filemodul.getContent());
    }
    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable int id) {
        fileService.deleteFile(id);
        return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
    }
    @PostMapping("deleteByName/{name}")
    public ResponseEntity<String> deleteFileByName(@PathVariable String name) {
        Filemon filemodul = fileService.getFileByName(name);
        if (filemodul != null) {
            fileService.deleteFile(filemodul.getId());
            return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addAdmin")
    public ResponseEntity<User> addAdmin(@RequestBody User user) {
       user.setRoles(Roles.ROLES_ADMIN);
       User newuser= userService.saveUser(user);
       return new ResponseEntity<>(newuser, HttpStatus.OK);
    }

}
