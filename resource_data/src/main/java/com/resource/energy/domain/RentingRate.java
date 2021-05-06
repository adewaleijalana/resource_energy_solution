package com.resource.energy.domain;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import com.resource.energy.domain.xtras.Genre;
import com.resource.energy.domain.xtras.VideoType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "renting_rate")
@EqualsAndHashCode(callSuper = false)
public class RentingRate extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -6404814444975560923L;

    @Column(name = "video_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private VideoType videoType;

    @Column(name = "rate", nullable = false)
    private BigDecimal rate;

    @Override
    public String toString() {
        return "RentingRate{" +
                "videoType=" + videoType +
                ", rate=" + rate +
                '}';
    }
}
