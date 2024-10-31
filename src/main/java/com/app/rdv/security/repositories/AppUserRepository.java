package com.app.rdv.security.repositories;



import com.app.rdv.security.entites.AppRole;
import com.app.rdv.security.entites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

    boolean existsByUsername(String username);


}