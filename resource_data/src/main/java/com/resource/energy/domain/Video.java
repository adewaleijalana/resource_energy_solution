package com.resource.energy.domain;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import com.resource.energy.domain.xtras.Genre;
import com.resource.energy.domain.xtras.VideoType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Video extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -6404814444975560923L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "video_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private VideoType videoType;

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "maximum_age", nullable = false)
    private int maximumAge;

    @Column(name = "year_released")
    private String yearReleased;

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", videoType=" + videoType +
                ", genre=" + genre +
                ", maximumAge=" + maximumAge +
                ", yearReleased='" + yearReleased + '\'' +
                '}';
    }
}
