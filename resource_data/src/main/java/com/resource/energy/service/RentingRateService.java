package com.resource.energy.service;

import com.resource.energy.domain.RentingRate;
import com.resource.energy.dto.RentingRateDTO;
import com.resource.energy.repository.RentingRateRepository;

import java.util.Collection;

public interface RentingRateService extends AbstractService<RentingRate, String> {

    RentingRateRepository getRepository();

    RentingRate getNewWithDefaults();

    RentingRateDTO entity2DTO(RentingRate entity);

    Collection<RentingRateDTO> entities2DTOs(Collection<RentingRate> entities);

    RentingRate dto2Entity(RentingRateDTO dto);

    Collection<RentingRate> dtos2Entities(Collection<RentingRateDTO> dtos);

}
