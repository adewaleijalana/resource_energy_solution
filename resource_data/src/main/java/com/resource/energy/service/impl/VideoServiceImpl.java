package com.resource.energy.service.impl;

import com.resource.energy.domain.Video;
import com.resource.energy.dto.VideoDTO;
import com.resource.energy.repository.VideoRepository;
import com.resource.energy.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class VideoServiceImpl extends AbstractServiceImpl<Video, String>
        implements VideoService {

    @Autowired
    private VideoRepository repository;

    public VideoServiceImpl() {
        super(Video.class);
    }

    @Override
    public VideoRepository getRepository() {
        return repository;
    }

    @Override
    public Video getNewWithDefaults() {
        return new Video();
    }

    @Override
    public VideoDTO entity2DTO(Video entity) {
        return VideoDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .videoType(entity.getVideoType().name())
                .genre(entity.getGenre().name())
                .maximumAge(entity.getMaximumAge())
                .yearReleased(entity.getYearReleased())
                .build();
    }

    @Override
    public Collection<VideoDTO> entities2DTOs(Collection<Video> entities) {
        return entities.stream()
                .map(this::entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public Video dto2Entity(VideoDTO dto) {
        return repository.getOne(dto.getId());
    }

    @Override
    public Collection<Video> dtos2Entities(Collection<VideoDTO> dtos) {
        return dtos.stream()
                .map(this::dto2Entity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Video> findByIDWithRef(String id) {
        return getDao.findById(id);
    }
}
