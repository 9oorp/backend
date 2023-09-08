package com.goorp.backend.dto;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class ApiResponseDto {
    boolean ok;
    Map<String, String> data;
}
