package com.resource.energy.domain;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "app_user_roles")
@EqualsAndHashCode(callSuper = false)
public class AppUserRoles extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -145988244986476123L;

    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "app_role_id", nullable = false)
    private AppRole appRole;

}
