package com.resource.energy.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentVideoRequest implements Serializable {

    private static final long serialVersionUID = -1082623356918852046L;

    @NotEmpty(message = "userName cannot be empty")
    private String userName;

    @NotEmpty(message = "videoTitle cannot be empty")
    private String videoTitle;

    @NotNull(message = "numberOfDays cannot be empty")
    //@NotEmpty(message = "numberOfDays cannot be empty")
    private Integer numberOfDays;

    @Override
    public String toString() {
        return "RentVideoRequest{" +
                "userName='" + userName + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", numberOfDays=" + numberOfDays +
                '}';
    }
}
