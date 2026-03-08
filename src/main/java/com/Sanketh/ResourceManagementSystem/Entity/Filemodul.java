package com.Sanketh.ResourceManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private byte[] content;


}
