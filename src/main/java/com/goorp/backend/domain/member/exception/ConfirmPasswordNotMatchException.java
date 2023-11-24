package com.goorp.backend.domain.member.exception;

import com.goorp.backend.api.exception.DomainException;
import com.goorp.backend.api.exception.ErrorCode;

public class ConfirmPasswordNotMatchException extends DomainException {
    public ConfirmPasswordNotMatchException() {
        super(ErrorCode.PASSWORD_NOT_SAME, "passwordConfirm이 password와 다릅니다!");
    }
}
