package com.app.rdv.security.controller;

import com.app.rdv.security.entites.AppRole;
import com.app.rdv.security.entites.AppUser;
import com.app.rdv.security.service.IServiceAuthentication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final IServiceAuthentication serviceAuthentication;

    @Autowired
    public AuthenticationController(IServiceAuthentication serviceAuthentication) {
        this.serviceAuthentication = serviceAuthentication;
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> registerUser(@Valid @RequestBody AppUser user) {
        AppUser newUser = serviceAuthentication.createAppUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/role")
    public ResponseEntity<AppRole> addRole(@Valid @RequestBody AppRole role) {
        AppRole newRole = serviceAuthentication.createAppRole(role);
        return ResponseEntity.ok(newRole);
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<String> addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        AppUser user = serviceAuthentication.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        AppRole role = serviceAuthentication.getRoleByName(roleName);
        if (role == null) {
            return ResponseEntity.badRequest().body("Role not found");
        }

        user.getRoles().add(role);
        serviceAuthentication.createAppUser(user);
        return ResponseEntity.ok("Role added to user successfully");
    }
}