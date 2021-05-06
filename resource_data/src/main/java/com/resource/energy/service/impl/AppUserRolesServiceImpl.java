package com.resource.energy.service.impl;


import com.resource.energy.domain.AppUserRoles;
import com.resource.energy.dto.AppUserDTO;
import com.resource.energy.dto.AppUserRolesDTO;
import com.resource.energy.repository.AppUserRolesRepository;
import com.resource.energy.service.AppUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppUserRolesServiceImpl extends AbstractServiceImpl<AppUserRoles, String>
        implements AppUserRolesService {

    @Autowired
    private AppUserRolesRepository repository;

    public AppUserRolesServiceImpl() {
        super(AppUserRoles.class);
    }

    @Override
    public AppUserRolesRepository getRepository() {
        return repository;
    }

    @Override
    public AppUserRoles getNewWithDefaults() {
        return new AppUserRoles();
    }

    @Override
    public AppUserRolesDTO entity2DTO(AppUserRoles entity) {
        return AppUserRolesDTO.builder()
                .id(entity.getId())
                .appUserId(entity.getAppUser().getId())
                .appRoleId(entity.getAppRole().getId())
                .build();
    }

    @Override
    public Collection<AppUserRolesDTO> entities2DTOs(Collection<AppUserRoles> entities) {
        return entities.stream()
                .map(this::entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserRoles dto2Entity(AppUserRolesDTO dto) {
        return repository.getOne(dto.getId());
    }

    @Override
    public Collection<AppUserRoles> dtos2Entities(Collection<AppUserRolesDTO> dtos) {
        return dtos.stream()
                .map(this::dto2Entity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppUserRoles> findByIDWithRef(String id) {
        return getDao.findById(id);
    }
}
