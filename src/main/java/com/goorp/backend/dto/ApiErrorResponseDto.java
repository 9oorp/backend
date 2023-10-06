package com.goorp.backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiErrorResponseDto {
    boolean ok;
    String errorMessage;
}
