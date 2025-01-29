package com.example.toylabs.application.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse(Integer status,
                          String message,
                          Object data) {

    private static final String DEFAULT_MESSAGE = "success";

    public ApiResponse(Object data) {
        this(
                HttpStatus.OK.value(),
                DEFAULT_MESSAGE,
                data
        );
    }

    public ApiResponse(String message, HttpStatus status) {
        this(
                status.value(),
                message,
                null
        );
    }
}
