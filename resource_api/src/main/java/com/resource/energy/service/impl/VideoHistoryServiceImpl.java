package com.resource.energy.service.impl;

import com.resource.energy.domain.VideoRentingHistory;
import com.resource.energy.response.VideoHistoryResponse;
import com.resource.energy.response.VideoHistoryResponses;
import com.resource.energy.service.VideoHistoryService;
import com.resource.energy.service.VideoRentingHistoryService;
import com.resource.energy.util.AppUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VideoHistoryServiceImpl implements VideoHistoryService {

    private final VideoRentingHistoryService rentingHistoryService;

    public VideoHistoryServiceImpl(VideoRentingHistoryService rentingHistoryService) {
        this.rentingHistoryService = rentingHistoryService;
    }

    @Override
    public VideoHistoryResponses getVideoHistory(String username, Date createdDate,
                                                 int pageNo, int pageSize) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Page<VideoRentingHistory> historyPage = Page.empty();
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("username"));
        final ZoneId id = ZoneId.systemDefault();

        if (AppUtil.INSTANCE.stringIsNullOrEmpty(username) && null == createdDate){
            log.info("getting all the records");
            historyPage =
                    this.rentingHistoryService.getRepository()
                    .findAll(pageable);
        }

        if (!AppUtil.INSTANCE.stringIsNullOrEmpty(username) || null != createdDate){
            assert createdDate != null;
            log.info("getting all the records using username: {} or created date: {}",
                    username, createdDate);
            ZonedDateTime createdDateInZonedDateTime =
                    ZonedDateTime.ofInstant(createdDate.toInstant(), id);
            historyPage =
                    this.rentingHistoryService.getRepository()
                            .findAllByUsernameOrCreatedBy(username, createdDateInZonedDateTime, pageable);
        }

        if (historyPage.hasContent()){
            log.info("there are records");
            List<VideoRentingHistory> videoRentingHistories = historyPage.getContent();
            List<VideoHistoryResponse> videoHistoryResponses =
                    videoRentingHistories.stream()
                    .map(videoRentingHistory ->
                            new VideoHistoryResponse(videoRentingHistory.getUsername(),
                                    videoRentingHistory.getVideoTitle(),
                                    videoRentingHistory.getNumberOfDays(),
                                    videoRentingHistory.getRentingFee(),
                                    dateFormat.format(Date.from(videoRentingHistory.getCreatedDate().toInstant()))))
                    .collect(Collectors.toList());

            return VideoHistoryResponses.builder()
                    .currentPage(historyPage.getNumber())
                    .totalItems(historyPage.getTotalElements())
                    .totalPages(historyPage.getTotalPages())
                    .videoHistories(videoHistoryResponses)
                    .build();
        }
        System.out.println("has no contents");
        log.info("has no contents");
        return VideoHistoryResponses.builder()
                .videoHistories(new ArrayList<>())
                .build();
    }
}
