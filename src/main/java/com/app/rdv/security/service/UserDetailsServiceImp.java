package com.app.rdv.security.service;

import com.app.rdv.security.entites.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final IServiceAuthentication iServiceAuthentication;

    @Autowired
    public UserDetailsServiceImp(IServiceAuthentication iServiceAuthentication) {
        this.iServiceAuthentication = iServiceAuthentication;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iServiceAuthentication.getUserByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        String[] roles = appUser.getRoles().stream()
                .map(role -> role.getRole())
                .toArray(String[]::new);

        return User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles)
                .build();
    }
}