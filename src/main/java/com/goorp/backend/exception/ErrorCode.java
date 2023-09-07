package com.goorp.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCode {
    MEMBER_NAME_DUPLICATED(HttpStatus.CONFLICT, ""),
    MEMBER_NAME_NOT_FOUNT(HttpStatus.NOT_FOUND, ""),
    PASSWORD_NOT_CONFIRM(HttpStatus.CONFLICT, ""),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "");

    private HttpStatus httpStatus;
    private String message;
}
