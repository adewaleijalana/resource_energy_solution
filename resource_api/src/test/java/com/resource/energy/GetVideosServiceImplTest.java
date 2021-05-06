package com.resource.energy;

import com.resource.energy.domain.Video;
import com.resource.energy.exception.ModelNotFoundException;
import com.resource.energy.response.VideoResponse;
import com.resource.energy.response.VideoResponses;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetVideosServiceImplTest extends ResourceApiApplicationTests{

    @Test
    public void getVideos(){
        VideoResponses videoResponses =
                getVideosService.getVideos(1, 3);

        assertFalse(videoResponses.getVideos().isEmpty());

    }

    @ParameterizedTest
    @ValueSource(strings = {"Mad Dog", "Suicide Squad", "EXTRACTION"})
    public void find_video_by_title_successful(String title){
        Video foundVideo = getVideosService.findVideoByTitle(title);
        assertNotNull(foundVideo);
    }

    @Test
    public void find_video_by_title_not_found_exception(){
        String videoTitle = "title";
        Exception exception = assertThrows(ModelNotFoundException.class, () -> {
            Video foundVideo = getVideosService.findVideoByTitle(videoTitle);
        });

        String expectedMessage = "Video with title: " + videoTitle + " does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}