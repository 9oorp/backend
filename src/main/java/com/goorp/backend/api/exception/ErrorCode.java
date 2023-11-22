package com.goorp.backend.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCode {
    ID_DUPLICATED(HttpStatus.CONFLICT, ""),
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, ""),
    PASSWORD_NOT_SAME(HttpStatus.UNAUTHORIZED, ""),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, ""),
    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, ""),
    NOT_FOUND_POST(HttpStatus.NOT_FOUND, ""),
    NESTED_REPLY_EXCEPTION(HttpStatus.BAD_REQUEST, ""),
    NOT_FOUND_COMMENT(HttpStatus.NOT_FOUND, "");
    private HttpStatus httpStatus;
    private String message;
}