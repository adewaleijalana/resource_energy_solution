package com.resource.energy.service;



import com.resource.energy.domain.AppUserRoles;
import com.resource.energy.dto.AppUserRolesDTO;
import com.resource.energy.repository.AppUserRolesRepository;

import java.util.Collection;

public interface AppUserRolesService extends AbstractService<AppUserRoles, String> {

    AppUserRolesRepository getRepository();

    AppUserRoles getNewWithDefaults();

    AppUserRolesDTO entity2DTO(AppUserRoles entity);

    Collection<AppUserRolesDTO> entities2DTOs(Collection<AppUserRoles> entities);

    AppUserRoles dto2Entity(AppUserRolesDTO dto);

    Collection<AppUserRoles> dtos2Entities(Collection<AppUserRolesDTO> dtos);

}
