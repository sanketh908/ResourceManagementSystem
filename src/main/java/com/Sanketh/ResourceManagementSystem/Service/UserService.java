package com.Sanketh.ResourceManagementSystem.Service;

import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Enums.Roles;
import com.Sanketh.ResourceManagementSystem.Repository.Userrepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
private final Userrepo userRepository;

    public UserService(Userrepo userRepository) {
        this.userRepository = userRepository;
    }
    public User saveAdmin(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Roles.ROLE_ADMIN);
        return userRepository.save(user);
    }
    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Roles.ROLE_USER);
        return userRepository.save(user);
    }
    public  User getUserById(Integer id)
    {
        Optional<User> user= userRepository.findById(id);
        return user.orElseThrow(()->new UsernameNotFoundException("User not found with id: "+id));
    }
}
