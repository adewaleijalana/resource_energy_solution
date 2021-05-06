package com.resource.energy.service.impl;

import com.resource.energy.domain.VideoRentingHistory;
import com.resource.energy.dto.VideoRentingHistoryDTO;
import com.resource.energy.repository.VideoRentingHistoryRepository;
import com.resource.energy.service.VideoRentingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class VideoRentingHistoryServiceImpl extends AbstractServiceImpl<VideoRentingHistory, String>
        implements VideoRentingHistoryService {

    @Autowired
    private VideoRentingHistoryRepository repository;

    public VideoRentingHistoryServiceImpl() {
        super(VideoRentingHistory.class);
    }

    @Override
    public VideoRentingHistoryRepository getRepository() {
        return repository;
    }

    @Override
    public VideoRentingHistory getNewWithDefaults() {
        return new VideoRentingHistory();
    }

    @Override
    public VideoRentingHistoryDTO entity2DTO(VideoRentingHistory entity) {
        return VideoRentingHistoryDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .videoTitle(entity.getVideoTitle())
                .numberOfDays(entity.getNumberOfDays())
                .rentingFee(entity.getRentingFee())
                .build();
    }

    @Override
    public Collection<VideoRentingHistoryDTO> entities2DTOs(Collection<VideoRentingHistory> entities) {
        return entities.stream()
                .map(this::entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public VideoRentingHistory dto2Entity(VideoRentingHistoryDTO dto) {
        return repository.getOne(dto.getId());
    }

    @Override
    public Collection<VideoRentingHistory> dtos2Entities(Collection<VideoRentingHistoryDTO> dtos) {
        return dtos.stream()
                .map(this::dto2Entity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VideoRentingHistory> findByIDWithRef(String id) {
        return getDao.findById(id);
    }
}
