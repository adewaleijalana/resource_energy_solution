package com.resource.energy.service.impl;

import com.resource.energy.domain.RentingRate;
import com.resource.energy.domain.Video;
import com.resource.energy.domain.VideoRentingHistory;
import com.resource.energy.exception.BadRequestException;
import com.resource.energy.factory.CalculatePriceFactory;
import com.resource.energy.request.RentVideoRequest;
import com.resource.energy.response.RentVideoResponse;
import com.resource.energy.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class RentVideoServiceImpl implements RentVideoService {

    private final GetVideosService getVideosService;
    private final RentingRateService rentingRateService;
    private final LoginUsernameService loginUsernameService;
    private final CalculatePriceFactory calculatePriceFactory;
    private final VideoRentingHistoryService rentingHistoryService;

    public RentVideoServiceImpl(GetVideosService getVideosService,
                                RentingRateService rentingRateService,
                                LoginUsernameService loginUsernameService,
                                CalculatePriceFactory calculatePriceFactory,
                                VideoRentingHistoryService rentingHistoryService) {
        this.getVideosService = getVideosService;
        this.rentingRateService = rentingRateService;
        this.loginUsernameService = loginUsernameService;
        this.calculatePriceFactory = calculatePriceFactory;
        this.rentingHistoryService = rentingHistoryService;
    }

    @Override
    public RentVideoResponse rentVideo(RentVideoRequest request) {
        String username = this.loginUsernameService.getLoginUsername();

        if (!request.getUserName().equals(username)) {
            throw new BadRequestException("Wrong username in the request");
        }

        try {
            Video video = this.getVideosService.findVideoByTitle(request.getVideoTitle());
            RentingRate rentingRate =
                    this.rentingRateService.getRepository()
                            .findRentingRateByVideoType(video.getVideoType());

            CalculatePrice calculatePrice = this.calculatePriceFactory.buildCalculatePrice(video);
            BigDecimal price =
                    calculatePrice
                            .calculatePrice(video, rentingRate.getRate(), request.getNumberOfDays());

            VideoRentingHistory videoRentingHistory = saveRentingHistory(request, price);

            if (null != price) {
                return RentVideoResponse
                        .builder()
                        .userName(request.getUserName())
                        .rentalPrice(price)
                        .build();
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return RentVideoResponse
                .builder()
                .userName(request.getUserName())
                //.rentalPrice(price)
                .build();
    }

    private VideoRentingHistory saveRentingHistory(RentVideoRequest request, BigDecimal price) {
        VideoRentingHistory rentingHistory = VideoRentingHistory.builder()
                .username(request.getUserName())
                .videoTitle(request.getVideoTitle())
                .numberOfDays(request.getNumberOfDays())
                .rentingFee(price)
                .build();

        return this.rentingHistoryService.saveNew(rentingHistory, null);
    }
}
