package com.Sanketh.ResourceManagementSystem.Controller;

import com.Sanketh.ResourceManagementSystem.Entity.Filemon;
import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Security.UserPrincipal;
import com.Sanketh.ResourceManagementSystem.Service.FileService;
import com.Sanketh.ResourceManagementSystem.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;



@RestController
@RequestMapping("/usersfiles")
public class UserController {
    private final UserService userService;
    private final FileService fileService;

    public UserController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile() {
      UserPrincipal  userPrincipal = (UserPrincipal) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
      User user= userService.getUserById(userPrincipal.getuserId());
      return  new ResponseEntity<>(user, HttpStatus.OK);



    }
    @GetMapping("/getall")
    public ResponseEntity<List<Filemon>> getFiles() {
       List<Filemon> files= fileService.getAllFile();
       return new  ResponseEntity<>(files, HttpStatus.OK);

    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Filemon> getFileById(@PathVariable int  id) {
        Filemon filemodul= fileService.getFile(id);
        return new  ResponseEntity<>(filemodul, HttpStatus.OK);
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Filemon> getFileByName(@PathVariable String name) {
        Filemon filemodul=fileService.getFileByName(name);
        return new   ResponseEntity<>(filemodul, HttpStatus.OK);
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {
        Filemon filemodul = fileService.getFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(filemodul.getFiletype()))
                .header("Content-Disposition", "attachment; filename=\"" + filemodul.getFilename() + "\"")
                .body(filemodul.getContent());
    }

}
