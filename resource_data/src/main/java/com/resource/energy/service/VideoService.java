package com.resource.energy.service;

import com.resource.energy.domain.Video;
import com.resource.energy.dto.VideoDTO;
import com.resource.energy.repository.VideoRepository;

import java.util.Collection;

public interface VideoService extends AbstractService<Video, String> {

    VideoRepository getRepository();

    Video getNewWithDefaults();

    VideoDTO entity2DTO(Video entity);

    Collection<VideoDTO> entities2DTOs(Collection<Video> entities);

    Video dto2Entity(VideoDTO dto);

    Collection<Video> dtos2Entities(Collection<VideoDTO> dtos);

}
