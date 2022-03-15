package com.group1.theBookSpot.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelApiExceptionResponse {
    @JsonProperty("status")
    private String status;

    @JsonProperty("errorCode")
    private Integer errorCode;

    @JsonProperty("userMessage")
    private String userMessage;
}
