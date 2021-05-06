package com.resource.energy.service.impl;

import com.resource.energy.exception.ModelNotFoundException;
import com.resource.energy.response.VideoResponse;
import com.resource.energy.domain.Video;
import com.resource.energy.response.VideoResponses;
import com.resource.energy.service.GetVideosService;
import com.resource.energy.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GetVideosServiceImpl implements GetVideosService {

    private final VideoService videoService;

    public GetVideosServiceImpl(VideoService videoService) {
        this.videoService = videoService;
    }

    @Override
    public VideoResponses getVideos(int pageNo, int pageSize) {
        try {
            log.info("fetching videos");
            List<VideoResponse> videoResponses;
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            Page<Video> page = videoService.getRepository().findAll(pageable);
            if (page.hasContent()){
                List<Video> videos = page.getContent();
                videoResponses = videos.stream()
                        .map(video -> new VideoResponse(video.getTitle(),
                                video.getVideoType().name(),
                                video.getGenre().name()))
                        .collect(Collectors.toList());
                log.info("returning video records");
                return VideoResponses.builder()
                        .currentPage(page.getNumber())
                        .totalItems(page.getTotalElements())
                        .totalPages(page.getTotalPages())
                        .videos(videoResponses)
                        .build();
            }

        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return VideoResponses.builder()
                .videos(new ArrayList<>())
                .build();
    }

    @Override
    public Video findVideoByTitle(String videoTitle) throws ModelNotFoundException {
        return videoService.getRepository().findByTitle(videoTitle)
                .orElseThrow(() -> new ModelNotFoundException("Video with title: " + videoTitle + " does " +
                        "not exist"));
    }
}
