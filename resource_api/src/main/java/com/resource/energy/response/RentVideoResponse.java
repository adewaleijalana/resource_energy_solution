package com.resource.energy.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentVideoResponse implements Serializable {

    private static final long serialVersionUID = -8801058700542043837L;

    private String userName;
    private BigDecimal rentalPrice;

    @Override
    public String toString() {
        return "RentVideoResponse{" +
                "userName='" + userName + '\'' +
                ", rentalPrice=" + rentalPrice +
                '}';
    }
}
