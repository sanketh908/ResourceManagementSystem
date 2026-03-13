package com.Sanketh.ResourceManagementSystem.Service;

import com.Sanketh.ResourceManagementSystem.Entity.Filemon;
import com.Sanketh.ResourceManagementSystem.Repository.Filerepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileService {
   private final Filerepo filerepo;
    public FileService(Filerepo filerepo){

        this.filerepo = filerepo;
    }
    public Filemon addFile(MultipartFile file){
        try {
            Filemon Filemon = new Filemon();
            Filemon.setFilename(System.currentTimeMillis()+"-"+file.getOriginalFilename());
            Filemon.setFiletype(file.getContentType());
            Filemon.setContent(file.getBytes());
            return filerepo.save(Filemon);
        } catch (Exception e) {
            throw new RuntimeException("Failed to store file: " + e.getMessage());
        }

    }
    public Filemon getFile(int id){
        return filerepo.findById(id).orElseThrow(() -> new RuntimeException("File not found with id: " + id));

    }
    public List<Filemon> getAllFile(){
      return   filerepo.findAll();
    }
    public void deleteFile(int id){
        filerepo.deleteById(id);
    }


    public Filemon getFileByName(String filename) {
        return filerepo.findByFilename(filename);
    }
}
