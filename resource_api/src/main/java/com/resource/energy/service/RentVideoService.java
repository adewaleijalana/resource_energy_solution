package com.resource.energy.service;

import com.resource.energy.request.RentVideoRequest;
import com.resource.energy.response.RentVideoResponse;

public interface RentVideoService {

    RentVideoResponse rentVideo(RentVideoRequest request);
}
