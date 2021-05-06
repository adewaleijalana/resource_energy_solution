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
public class AppRoleDTO implements Serializable {

    private static final long serialVersionUID = 8281591906252925788L;

    private String id;
    private String name;

    @Override
    public String toString() {
        return "AppRoleDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
