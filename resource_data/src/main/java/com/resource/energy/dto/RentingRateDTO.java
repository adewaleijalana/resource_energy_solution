package com.resource.energy.dto;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
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
public class RentingRateDTO implements Serializable {

    private static final long serialVersionUID = 1901453262170738809L;

    private String id;
    private String title;
    private String videoType;
    private BigDecimal rate;

    @Override
    public String toString() {
        return "RentingRateDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", videoType='" + videoType + '\'' +
                ", rate=" + rate +
                '}';
    }
}
