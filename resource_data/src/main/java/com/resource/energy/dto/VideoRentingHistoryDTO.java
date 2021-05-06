package com.resource.energy.dto;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoRentingHistoryDTO implements Serializable {

    private static final long serialVersionUID = 986654732321928384L;

    private String id;
    private String videoTitle;
    private String username;
    private int numberOfDays;
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
