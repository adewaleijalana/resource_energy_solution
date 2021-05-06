package com.resource.energy.service.impl;

import com.resource.energy.domain.AppRole;
import com.resource.energy.dto.AppRoleDTO;
import com.resource.energy.repository.AppRoleRepository;
import com.resource.energy.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppRoleServiceImpl extends AbstractServiceImpl<AppRole, String>
        implements AppRoleService {

    @Autowired
    private AppRoleRepository repository;

    public AppRoleServiceImpl() {
        super(AppRole.class);
    }

    @Override
    public AppRoleRepository getRepository() {
        return repository;
    }

    @Override
    public AppRole getNewWithDefaults() {
        return new AppRole();
    }

    @Override
    public AppRoleDTO entity2DTO(AppRole entity) {
        return AppRoleDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Collection<AppRoleDTO> entities2DTOs(Collection<AppRole> entities) {
        return entities.stream()
                .map(this::entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppRole dto2Entity(AppRoleDTO dto) {
        return repository.getOne(dto.getId());
    }

    @Override
    public Collection<AppRole> dtos2Entities(Collection<AppRoleDTO> dtos) {
        return dtos.stream()
                .map(this::dto2Entity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppRole> findByIDWithRef(String id) {
        return getDao.findById(id);
    }
}
