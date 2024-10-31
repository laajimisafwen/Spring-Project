package com.app.rdv.security.service;

import com.app.rdv.security.entites.AppRole;
import com.app.rdv.security.entites.AppUser;

public interface IServiceAuthentication {
    AppUser createAppUser(AppUser user);

    AppRole createAppRole(AppRole role);

    AppUser getUserByUsername(String  username);

    AppRole getRoleByName(String roleName);
    AppUser updateAppUser(AppUser user);

}
