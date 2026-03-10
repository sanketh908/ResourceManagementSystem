package com.Sanketh.ResourceManagementSystem.Service;

import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Repository.Userrepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public  User getUserById(Integer id)
    {
        Optional<User> user= userRepository.findById(id);
        return user.orElseThrow(()->new UsernameNotFoundException("User not found with id: "+id));
    }
}
