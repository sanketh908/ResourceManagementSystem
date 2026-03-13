package com.Sanketh.ResourceManagementSystem.Security;

import com.Sanketh.ResourceManagementSystem.Entity.User;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
private  final User user;
    public UserPrincipal(User user) {
        this.user=user;

    }

    @Override
    @NullMarked
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRoles().name()));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }
    public Integer getuserId() {
        return user.getUserId();
    }
    @Override
    @NullMarked
    public String getUsername() {
        return user.getUsername();
    }
}
