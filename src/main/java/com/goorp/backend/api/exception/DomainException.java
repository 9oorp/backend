package com.goorp.backend.api.exception;

public abstract class DomainException extends BaseException {
    private final ErrorCode errorCode;
    public DomainException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
