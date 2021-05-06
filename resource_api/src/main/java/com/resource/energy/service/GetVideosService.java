package com.resource.energy.service;

import com.resource.energy.domain.Video;
import com.resource.energy.exception.ModelNotFoundException;
import com.resource.energy.response.VideoResponses;


public interface GetVideosService {

    VideoResponses getVideos(int pageNo, int pageSize);

    Video findVideoByTitle(String videoTitle) throws ModelNotFoundException;
}
