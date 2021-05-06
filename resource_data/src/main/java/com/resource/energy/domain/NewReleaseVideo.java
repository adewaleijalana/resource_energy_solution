package com.resource.energy.domain;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import com.resource.energy.domain.xtras.Genre;
import com.resource.energy.domain.xtras.VideoType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NewReleaseVideo extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 3102649849248833531L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "video_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private VideoType videoType;

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "year_released", nullable = false)
    private String yearReleased;

    @Override
    public String toString() {
        return "NewReleaseVideo{" +
                "title='" + title + '\'' +
                ", videoType=" + videoType +
                ", genre=" + genre +
                ", yearReleased='" + yearReleased + '\'' +
                '}';
    }
}
