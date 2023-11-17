package com.goorp.backend.api.response;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponseDto {

    boolean ok;
    Map<String, ?> data;
}
