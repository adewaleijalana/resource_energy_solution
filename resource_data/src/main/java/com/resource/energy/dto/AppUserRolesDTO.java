package com.resource.energy.dto;

import com.resource.energy.domain.AppRole;
import com.resource.energy.domain.AppUser;
import com.resource.energy.domain.xtras.AbstractBaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AppUserRolesDTO implements Serializable {

    private static final long serialVersionUID = 5932190864563262442L;

    private String id;
    private String appUserId;
    private String appRoleId;

    @Override
    public String toString() {
        return "AppUserRolesDTO{" +
                "id='" + id + '\'' +
                ", appUserId='" + appUserId + '\'' +
                ", appRoleId='" + appRoleId + '\'' +
                '}';
    }
}
