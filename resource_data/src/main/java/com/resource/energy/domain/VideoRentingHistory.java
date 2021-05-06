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
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "renting_history")
@EqualsAndHashCode(callSuper = false)
public class VideoRentingHistory extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -6404814444975560923L;

    @Column(name = "video_title", nullable = false)
    private String videoTitle;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "number_of_days", nullable = false)
    private int numberOfDays;

    @Column(name = "renting_fee")
    private BigDecimal rentingFee;

    @Override
    public String toString() {
        return "VideoRentingHistory{" +
                "videoTitle='" + videoTitle + '\'' +
                ", username='" + username + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", rentingFee=" + rentingFee +
                '}';
    }
}
