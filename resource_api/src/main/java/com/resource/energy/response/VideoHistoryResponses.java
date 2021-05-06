package com.resource.energy.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoHistoryResponses implements Serializable {

    private static final long serialVersionUID = -3467649168960173470L;

    private int currentPage;
    private long totalItems;
    private int totalPages;
    private List<VideoHistoryResponse> videoHistories;

    @Override
    public String toString() {
        return "VideoHistoryResponses{" +
                "currentPage=" + currentPage +
                ", totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                ", videos=" + videoHistories +
                '}';
    }
}
