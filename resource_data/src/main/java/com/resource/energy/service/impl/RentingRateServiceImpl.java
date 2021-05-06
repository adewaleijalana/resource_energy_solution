package com.resource.energy.service.impl;

import com.resource.energy.domain.RentingRate;
import com.resource.energy.dto.RentingRateDTO;
import com.resource.energy.repository.RentingRateRepository;
import com.resource.energy.service.RentingRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RentingRateServiceImpl extends AbstractServiceImpl<RentingRate, String>
        implements RentingRateService {

    @Autowired
    private RentingRateRepository repository;

    public RentingRateServiceImpl() {
        super(RentingRate.class);
    }

    @Override
    public RentingRateRepository getRepository() {
        return repository;
    }

    @Override
    public RentingRate getNewWithDefaults() {
        return new RentingRate();
    }

    @Override
    public RentingRateDTO entity2DTO(RentingRate entity) {
        return RentingRateDTO.builder()
                .id(entity.getId())
                .videoType(entity.getVideoType().name())
                .rate(entity.getRate())
                .build();
    }

    @Override
    public Collection<RentingRateDTO> entities2DTOs(Collection<RentingRate> entities) {
        return entities.stream()
                .map(this::entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public RentingRate dto2Entity(RentingRateDTO dto) {
        return repository.getOne(dto.getId());
    }

    @Override
    public Collection<RentingRate> dtos2Entities(Collection<RentingRateDTO> dtos) {
        return dtos.stream()
                .map(this::dto2Entity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RentingRate> findByIDWithRef(String id) {
        return getDao.findById(id);
    }
}
