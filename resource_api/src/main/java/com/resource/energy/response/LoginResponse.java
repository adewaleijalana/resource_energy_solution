package com.resource.energy.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -4228382111259508178L;

    @NotEmpty(message = "userName cannot be empty")
    private String responseCode;

    @NotEmpty(message = "videoTitle cannot be empty")
    private String responseMessage;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
