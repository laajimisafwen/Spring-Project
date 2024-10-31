package com.app.rdv.security.repositories;

import com.app.rdv.security.entites.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByRole(String role);

    boolean existsByRole(String role);

}
