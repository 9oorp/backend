package com.goorp.backend.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;
}