package com.resource.energy.dto;

import com.resource.energy.domain.xtras.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO implements Serializable {

    private static final long serialVersionUID = -6404814444975560923L;

    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "AppUserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
