package com.goorp.backend.api.exception;

public class EntityNotFoundException extends DomainException {
    private static final String formattedMessage = "%d번 ID를 가진 %s가 존재하지 않습니다.";
    public EntityNotFoundException(ErrorCode errorCode, Class<?> entityClass, Long id) {
        super(errorCode, String.format(formattedMessage, id, entityClass.getSimpleName()));
    }
}
