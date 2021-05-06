package com.resource.energy.domain;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import com.resource.energy.domain.xtras.Genre;
import com.resource.energy.domain.xtras.VideoType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "app_user")
@EqualsAndHashCode(callSuper = false)
public class AppUser extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 5837042579895805693L;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "app_user_roles",
            joinColumns = { @JoinColumn(name = "app_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "app_role_id") })
    private List<AppRole> roles;

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
