package com.resource.energy.advice;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorResponse {

    private ErrorCode error;
    private String message;
    private List<String> errorMessages;
}
