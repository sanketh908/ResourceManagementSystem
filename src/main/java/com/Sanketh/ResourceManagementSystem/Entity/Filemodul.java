package com.Sanketh.ResourceManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Filemodul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String filename;
    private String filetype;
    @Lob
    private byte[] content;


}
