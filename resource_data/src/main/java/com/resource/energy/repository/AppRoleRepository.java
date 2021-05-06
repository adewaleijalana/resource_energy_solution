package com.resource.energy.repository;


import com.resource.energy.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    AppRole findByName(String roleName);
}
