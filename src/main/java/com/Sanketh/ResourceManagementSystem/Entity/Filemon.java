package com.Sanketh.ResourceManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "filemon")
public class Filemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String filename;
    @Column(nullable = false)
    private String filetype;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    private byte[] content;


}
