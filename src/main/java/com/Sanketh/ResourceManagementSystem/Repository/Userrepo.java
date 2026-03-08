package com.Sanketh.ResourceManagementSystem.Repository;

import com.Sanketh.ResourceManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {
}
