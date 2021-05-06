package com.resource.energy.service.impl;

import com.resource.energy.domain.Video;
import com.resource.energy.service.CalculatePrice;

import java.math.BigDecimal;

public class ChildrenPriceImpl implements CalculatePrice {

    @Override
    public BigDecimal calculatePrice(Video video, BigDecimal rate, int numberOfDays) {
        return rate.multiply(new BigDecimal(numberOfDays))
                .add(new BigDecimal(video.getMaximumAge())
                        .divide(new BigDecimal(2), BigDecimal.ROUND_HALF_UP));
    }
}
