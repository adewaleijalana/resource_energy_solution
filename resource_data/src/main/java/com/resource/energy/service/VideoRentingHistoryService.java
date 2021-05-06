package com.resource.energy.service;

import com.resource.energy.domain.VideoRentingHistory;
import com.resource.energy.dto.VideoDTO;
import com.resource.energy.dto.VideoRentingHistoryDTO;
import com.resource.energy.repository.VideoRentingHistoryRepository;

import java.util.Collection;

public interface VideoRentingHistoryService extends AbstractService<VideoRentingHistory, String> {

    VideoRentingHistoryRepository getRepository();

    VideoRentingHistory getNewWithDefaults();

    VideoRentingHistoryDTO entity2DTO(VideoRentingHistory entity);

    Collection<VideoRentingHistoryDTO> entities2DTOs(Collection<VideoRentingHistory> entities);

    VideoRentingHistory dto2Entity(VideoRentingHistoryDTO dto);

    Collection<VideoRentingHistory> dtos2Entities(Collection<VideoRentingHistoryDTO> dtos);

}
