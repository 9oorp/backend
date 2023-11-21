package com.goorp.backend.api.exception;

import lombok.Getter;

@Getter
public abstract class DomainException extends BaseException {
    private final ErrorCode errorCode;
    private final String message;

    public DomainException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }


}
