package com.resource.energy.service.impl;

import com.resource.energy.domain.AppUser;
import com.resource.energy.dto.AppUserDTO;
import com.resource.energy.repository.AppUserRepository;
import com.resource.energy.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppUserServiceImpl extends AbstractServiceImpl<AppUser, String>
        implements AppUserService {

    @Autowired
    private AppUserRepository repository;

    public AppUserServiceImpl() {
        super(AppUser.class);
    }

    @Override
    public AppUserRepository getRepository() {
        return repository;
    }

    @Override
    public AppUser getNewWithDefaults() {
        return new AppUser();
    }

    @Override
    public AppUserDTO entity2DTO(AppUser entity) {
        return AppUserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public Collection<AppUserDTO> entities2DTOs(Collection<AppUser> entities) {
        return entities.stream()
                .map(this::entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppUser dto2Entity(AppUserDTO dto) {
        return repository.getOne(dto.getId());
    }

    @Override
    public Collection<AppUser> dtos2Entities(Collection<AppUserDTO> dtos) {
        return dtos.stream()
                .map(this::dto2Entity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppUser> findByIDWithRef(String id) {
        return getDao.findById(id);
    }
}
