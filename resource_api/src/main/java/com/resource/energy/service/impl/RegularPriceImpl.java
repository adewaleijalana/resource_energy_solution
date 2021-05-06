package com.resource.energy.service.impl;

import com.resource.energy.domain.Video;
import com.resource.energy.service.CalculatePrice;

import java.math.BigDecimal;

public class RegularPriceImpl implements CalculatePrice {

    @Override
    public BigDecimal calculatePrice(Video video, BigDecimal rate, int numberOfDays) {
        return rate.multiply(new BigDecimal(numberOfDays));
    }
}
