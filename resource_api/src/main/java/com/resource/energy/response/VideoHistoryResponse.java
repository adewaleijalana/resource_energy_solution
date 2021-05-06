package com.resource.energy.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoHistoryResponse implements Serializable {

    private static final long serialVersionUID = 6236904109265979479L;

    private String username;
    private String title;
    private int numberOfDays;
    private BigDecimal fee;
    private String createdDate;

    @Override
    public String toString() {
        return "VideoHistoryResponse{" +
                "username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", fee=" + fee +
                ", createdDate=" + createdDate +
                '}';
    }
}
