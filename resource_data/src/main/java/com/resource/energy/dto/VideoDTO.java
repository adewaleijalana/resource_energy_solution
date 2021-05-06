package com.resource.energy.dto;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import com.resource.energy.domain.xtras.Genre;
import com.resource.energy.domain.xtras.VideoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO implements Serializable {

    private static final long serialVersionUID = -7740510137697380812L;

    private String id;
    private String title;
    private String videoType;
    private String genre;
    private int maximumAge;
    private String yearReleased;

    @Override
    public String toString() {
        return "VideoDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", videoType='" + videoType + '\'' +
                ", genre='" + genre + '\'' +
                ", maximumAge=" + maximumAge +
                ", yearReleased='" + yearReleased + '\'' +
                '}';
    }
}
