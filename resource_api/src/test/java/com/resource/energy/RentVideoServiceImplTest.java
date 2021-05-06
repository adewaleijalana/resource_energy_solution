package com.resource.energy;

import com.resource.energy.domain.Video;
import com.resource.energy.exception.BadRequestException;
import com.resource.energy.exception.ModelNotFoundException;
import com.resource.energy.request.RentVideoRequest;
import com.resource.energy.response.RentVideoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class RentVideoServiceImplTest extends ResourceApiApplicationTests{

    @Test
    @WithMockUser(username = "rose")
    public void test_rent_regular_movie(){
        RentVideoRequest request = RentVideoRequest
                .builder()
                .userName("rose")
                .videoTitle("EXTRACTION")
                .numberOfDays(3)
                .build();

        RentVideoResponse response = rentVideoService.rentVideo(request);
        System.out.println(response.getRentalPrice());
        assertTrue(response.getRentalPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @WithMockUser(username = "rose")
    public void test_rent_children_movie(){
        RentVideoRequest request = RentVideoRequest
                .builder()
                .userName("rose")
                .videoTitle("Despicable Me")
                .numberOfDays(3)
                .build();

        RentVideoResponse response = rentVideoService.rentVideo(request);
        System.out.println(response.getRentalPrice());
        assertTrue(response.getRentalPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @WithMockUser(username = "rose")
    public void test_rent_children_movie_with_wrong_username_in_request(){
        RentVideoRequest request = RentVideoRequest
                .builder()
                .userName("rose2")
                .videoTitle("Despicable Me")
                .numberOfDays(3)
                .build();

        Exception exception = assertThrows(BadRequestException.class, () -> {
            RentVideoResponse response = rentVideoService.rentVideo(request);
        });

        String expectedMessage = "Wrong username in the request";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}