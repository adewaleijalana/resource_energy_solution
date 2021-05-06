package com.resource.energy.service;

import com.resource.energy.domain.Video;

import java.math.BigDecimal;

public interface CalculatePrice {

    BigDecimal calculatePrice(Video video, BigDecimal rate, int numberOfDays);
}
