package com.goorp.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCode {
    ID_DUPLICATED(HttpStatus.CONFLICT, ""),
    ID_NOT_FOUNT(HttpStatus.NOT_FOUND, ""),
    PASSWORD_NOT_SAME(HttpStatus.UNAUTHORIZED, ""),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, ""),
    ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, ""),
    NOT_FOUND_TOKEN(HttpStatus.NOT_FOUND, ""),
    NOT_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, ""),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, ""),
    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, ""),
    NOT_FOUND_POST(HttpStatus.NOT_FOUND, ""),
    NOT_FOUND_COMMENT(HttpStatus.NOT_FOUND, "");

    private HttpStatus httpStatus;
    private String message;
}