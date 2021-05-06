package com.resource.energy.service;

import com.resource.energy.domain.AppRole;
import com.resource.energy.dto.AppRoleDTO;
import com.resource.energy.repository.AppRoleRepository;

import java.util.Collection;

public interface AppRoleService extends AbstractService<AppRole, String> {

    AppRoleRepository getRepository();

    AppRole getNewWithDefaults();

    AppRoleDTO entity2DTO(AppRole entity);

    Collection<AppRoleDTO> entities2DTOs(Collection<AppRole> entities);

    AppRole dto2Entity(AppRoleDTO dto);

    Collection<AppRole> dtos2Entities(Collection<AppRoleDTO> dtos);

}
