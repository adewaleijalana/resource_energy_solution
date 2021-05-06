package com.resource.energy.service;

import com.resource.energy.response.VideoHistoryResponses;

import java.time.ZonedDateTime;
import java.util.Date;

public interface VideoHistoryService {

    VideoHistoryResponses getVideoHistory(String username, Date createdDate, int pageNo, int pageSize);
}
