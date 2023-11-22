package com.goorp.backend.domain.member.exception;

import com.goorp.backend.api.exception.DomainException;
import com.goorp.backend.api.exception.ErrorCode;

public class InvalidPasswordException extends DomainException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD, "비밀번호가 일치하지 않습니다!");
    }
}
