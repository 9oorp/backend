package com.goorp.backend.domain.member.exception;

import com.goorp.backend.api.exception.DomainException;
import com.goorp.backend.api.exception.ErrorCode;

public class AccountIdAlreadyExistException extends DomainException {
    public AccountIdAlreadyExistException() {
        super(ErrorCode.ID_DUPLICATED, "이미 존재하는 아이디입니다.");
    }
}
