package com.resource.energy.service.impl;

import com.resource.energy.domain.Video;
import com.resource.energy.service.CalculatePrice;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class NewReleasePriceImpl implements CalculatePrice {

    @Override
    public BigDecimal calculatePrice(Video video, BigDecimal rate, int numberOfDays) {

        System.out.println("video yearReleased: " + video.getYearReleased());
        int presentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("presentYear: " + presentYear);

        int yearsOfReleased = presentYear - Integer.parseInt(video.getYearReleased());
        System.out.println("yearsOfReleased: " + yearsOfReleased);
        return rate.multiply(new BigDecimal(numberOfDays))
                .subtract(new BigDecimal(yearsOfReleased));


    }
}
