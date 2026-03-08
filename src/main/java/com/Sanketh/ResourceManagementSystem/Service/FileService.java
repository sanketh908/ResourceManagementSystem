package com.Sanketh.ResourceManagementSystem.Service;

import com.Sanketh.ResourceManagementSystem.Entity.Filemodul;
import com.Sanketh.ResourceManagementSystem.Repository.Filerepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
   private final Filerepo filerepo;
    public FileService(Filerepo filerepo){

        this.filerepo = filerepo;
    }
    public Filemodul addFile(MultipartFile file){
        try {
            Filemodul filemodul = new Filemodul();
            filemodul.setFilename(file.getOriginalFilename());
            filemodul.setFiletype(file.getContentType());
            filemodul.setContent(file.getBytes());
            return filerepo.save(filemodul);
        } catch (Exception e) {
            throw new RuntimeException("Failed to store file: " + e.getMessage());
        }

    }
    public Filemodul getFile(int id){
        return filerepo.findById(id).orElseThrow(() -> new RuntimeException("File not found with id: " + id));

    }
}
