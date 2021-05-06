package com.resource.energy.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoResponse implements Serializable {

    private static final long serialVersionUID = -6041425721069053336L;

    private String title;
    private String videoType;
    private String genre;

    @Override
    public String toString() {
        return "VideoResponse{" +
                "title='" + title + '\'' +
                ", videoType='" + videoType + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
