package com.resource.energy.service;

import com.resource.energy.domain.AppUser;
import com.resource.energy.dto.AppUserDTO;
import com.resource.energy.repository.AppUserRepository;

import java.util.Collection;

public interface AppUserService extends AbstractService<AppUser, String> {

    AppUserRepository getRepository();

    AppUser getNewWithDefaults();

    AppUserDTO entity2DTO(AppUser entity);

    Collection<AppUserDTO> entities2DTOs(Collection<AppUser> entities);

    AppUser dto2Entity(AppUserDTO dto);

    Collection<AppUser> dtos2Entities(Collection<AppUserDTO> dtos);

}
