package com.resource.energy.controllers;

import com.resource.energy.request.LoginRequest;
import com.resource.energy.request.RentVideoRequest;
import com.resource.energy.response.LoginResponse;
import com.resource.energy.response.RentVideoResponse;
import com.resource.energy.response.VideoHistoryResponses;
import com.resource.energy.response.VideoResponses;
import com.resource.energy.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@RestController
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestMapping("/api/video/")
public class VideoController {

    public static final String VIDEOS = "videos";
    public static final String RENT_VIDEO = "rentVideo";
    public static final String RENTAL_HISTORY = "rentalHistory";
    public static final String LOGIN = "login";

    private final LoginService loginService;
    private final GetVideosService getVideosService;
    private final RentVideoService rentVideoService;
    private final VideoHistoryService videoHistoryService;

    public VideoController(LoginService loginService,
                           GetVideosService getVideosService,
                           RentVideoService rentVideoService,
                           VideoHistoryService videoHistoryService) {
        this.loginService = loginService;
        this.getVideosService = getVideosService;
        this.rentVideoService = rentVideoService;
        this.videoHistoryService = videoHistoryService;
    }

    @GetMapping(path = VIDEOS)
    public ResponseEntity<VideoResponses>
    getVideos(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
              @RequestParam(value = "size", defaultValue = "5", required = false) int size){
        VideoResponses videos = this.getVideosService.getVideos(page, size);
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PostMapping(path = RENT_VIDEO)
    public ResponseEntity<RentVideoResponse> rentVideo(@RequestBody @Valid RentVideoRequest request){
        RentVideoResponse response = this.rentVideoService.rentVideo(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = RENTAL_HISTORY)
    public ResponseEntity<VideoHistoryResponses>
    getVideoHistory(@RequestParam(value = "username", required = false) String username,
                    @RequestParam(value = "createdDate", required = false)
                    @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdDate,
                    @RequestParam(value = "page", defaultValue = "0", required = false) int page,
              @RequestParam(value = "size", defaultValue = "5", required = false) int size){
        VideoHistoryResponses historyResponses =
                this.videoHistoryService.getVideoHistory(username, createdDate, page, size);
        return new ResponseEntity<>(historyResponses, HttpStatus.OK);
    }

    @PostMapping(path = LOGIN)
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request){
        LoginResponse loginResponse = loginService.login(request);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
