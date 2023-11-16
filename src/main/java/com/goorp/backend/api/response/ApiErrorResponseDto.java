package com.goorp.backend.api.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiErrorResponseDto {

    boolean ok;
    String errorMessage;
}
