package com.resource.energy.repository;


import com.resource.energy.domain.AppUserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRolesRepository extends JpaRepository<AppUserRoles, String> {

}
