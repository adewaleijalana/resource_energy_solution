package com.resource.energy.repository;

import com.resource.energy.domain.RentingRate;
import com.resource.energy.domain.xtras.VideoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentingRateRepository extends JpaRepository<RentingRate, String> {

    RentingRate findRentingRateByVideoType(VideoType videoType);

}
