package com.goorp.backend.api.exception;

public class EntityNotFoundException extends DomainException {
    private static final String formattedMessage = "%s번 ID를 가진 %s가 존재하지 않습니다.";
    public EntityNotFoundException(Class<?> entityClass, Object id) {
        super(ErrorCode.ENTITY_NOT_FOUND, String.format(formattedMessage, id, entityClass.getSimpleName()));
    }
}
