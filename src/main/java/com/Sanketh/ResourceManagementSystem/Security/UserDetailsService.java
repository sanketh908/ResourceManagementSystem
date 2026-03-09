package com.Sanketh.ResourceManagementSystem.Security;


import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Repository.Userrepo;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServic implements UserDetailsService {
private final Userrepo userrepo;

    public UserDetailsServic(Userrepo userrepo) {
        this.userrepo = userrepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user=userrepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found with username: "+username));
    }
}
