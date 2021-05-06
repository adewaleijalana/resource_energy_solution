package com.resource.energy;

import com.resource.energy.domain.Video;
import com.resource.energy.service.CalculatePrice;
import com.resource.energy.service.impl.NewReleasePriceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculatePriceTest {

    @Test
    public void testNewReleasePrice(){
        Video video = Video.builder()
                .yearReleased("2010")
                .build();
        CalculatePrice calculatePrice = new NewReleasePriceImpl();

        BigDecimal bigDecimal =
                calculatePrice.calculatePrice(video, new BigDecimal(15), 3);

        System.out.println(bigDecimal.toString());
    }
}