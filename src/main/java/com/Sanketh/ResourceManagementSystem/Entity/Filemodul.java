package com.Sanketh.ResourceManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@Entity
public class Filemodul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String filename;
    @Column(nullable = false)
    private String filetype;
    @Lob
    @Column(nullable = false)
    private byte[] content;


}
