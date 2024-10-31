package com.app.rdv.security.service;

import com.app.rdv.security.entites.AppRole;
import com.app.rdv.security.entites.AppUser;
import com.app.rdv.security.repositories.AppRoleRepository;
import com.app.rdv.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceAuthentication implements IServiceAuthentication {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public ServiceAuthentication(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

@Override
    public AppUser createAppUser(AppUser user) {
        if (appUserRepository.existsByUsername(user.getUsername())) {
            throw new IllegalStateException("Username already in use.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

@Override
    public AppRole createAppRole(AppRole role) {
        if (appRoleRepository.existsByRole(role.getRole())) {
            throw new IllegalStateException("Role already exists.");
        }
        return appRoleRepository.save(role);
    }
    @Override
    public AppUser getUserByUsername(String username) {
        Optional<AppUser> user = Optional.ofNullable(appUserRepository.findByUsername(username));
        return user.orElse(null);
    }
    @Override
    public AppRole getRoleByName(String roleName) {
        return appRoleRepository.findByRole(roleName);
    }
    @Override
    public AppUser updateAppUser(AppUser user) {
        return appUserRepository.save(user);
    }


}
