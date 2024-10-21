package com.proyectos.userservice.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "timestamp",
        "codigo",
        "detail"
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @JsonProperty("timestamp")
    private LocalDateTime dateTime;
    @JsonProperty("codigo")
    private int code;
    @JsonProperty("detail")
    private String detail;
}
