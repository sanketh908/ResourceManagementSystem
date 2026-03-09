package com.Sanketh.ResourceManagementSystem.Service;

import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Repository.Userrepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
private final Userrepo userRepository;

    public UserService(Userrepo userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }
}
