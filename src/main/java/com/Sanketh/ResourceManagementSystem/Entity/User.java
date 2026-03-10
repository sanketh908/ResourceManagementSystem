package com.Sanketh.ResourceManagementSystem.Entity;

import com.Sanketh.ResourceManagementSystem.Enums.Roles;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @OneToMany(mappedBy ="files",cascade = CascadeType.ALL)
    private List<Filemodul> filemoduls;
}
