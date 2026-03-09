package com.Sanketh.ResourceManagementSystem.Repository;

import com.Sanketh.ResourceManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
