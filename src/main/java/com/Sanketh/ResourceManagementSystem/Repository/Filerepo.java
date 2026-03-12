package com.Sanketh.ResourceManagementSystem.Repository;

import com.Sanketh.ResourceManagementSystem.Entity.Filemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Filerepo  extends JpaRepository<Filemon, Integer> {
   Filemon findByFilename(String filename);
}
