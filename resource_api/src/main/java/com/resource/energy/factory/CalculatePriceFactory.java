package com.resource.energy.factory;

import com.resource.energy.domain.Video;
import com.resource.energy.domain.xtras.VideoType;
import com.resource.energy.service.CalculatePrice;
import com.resource.energy.service.impl.ChildrenPriceImpl;
import com.resource.energy.service.impl.NewReleasePriceImpl;
import com.resource.energy.service.impl.RegularPriceImpl;
import org.springframework.stereotype.Component;

@Component
public class CalculatePriceFactory {

    public CalculatePrice buildCalculatePrice(Video video){

        if (video.getVideoType().equals(VideoType.CHILDREN)){
            return new ChildrenPriceImpl();
        }

        if (video.getVideoType().equals(VideoType.REGULAR)){
            return new RegularPriceImpl();
        }

        if (video.getVideoType().equals(VideoType.NEW_RELEASE)){
            return new NewReleasePriceImpl();
        }

        return null;
    }
}
