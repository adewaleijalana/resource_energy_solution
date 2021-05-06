package com.resource.energy.domain;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ChildrenVideo extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 4246060239295469746L;

    private int maximumAge;

    @Override
    public String toString() {
        return "ChildrenVideo{" +
                "maximumAge=" + maximumAge +
                '}';
    }
}
