package com.resource.energy.domain;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "app_role")
@EqualsAndHashCode(callSuper = false)
public class AppRole extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -145988244986476123L;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<AppUser> appUsers;


    @Override
    public String toString() {
        return "AppRole{" +
                "name='" + name + '\'' +
                '}';
    }
}
