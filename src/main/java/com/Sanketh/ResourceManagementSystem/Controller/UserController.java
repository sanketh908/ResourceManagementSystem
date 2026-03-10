package com.Sanketh.ResourceManagementSystem.Controller;

import com.Sanketh.ResourceManagementSystem.Entity.Filemodul;
import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Security.UserPrincipal;
import com.Sanketh.ResourceManagementSystem.Service.FileService;
import com.Sanketh.ResourceManagementSystem.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    public ResponseEntity<List<Filemodul>> getFiles() {
       List<Filemodul> files= fileService.getAllFile();
       return new  ResponseEntity<>(files, HttpStatus.OK);

    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Filemodul> getFileById(@PathVariable int  id) {
        Filemodul filemodul= fileService.getFile(id);
        return new  ResponseEntity<>(filemodul, HttpStatus.OK);
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Filemodul> getFileByName(@PathVariable String name) {
        Filemodul filemodul=fileService.getFileByName(name);
    }

}
