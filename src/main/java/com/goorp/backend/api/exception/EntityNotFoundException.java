package com.goorp.backend.api.exception;

public class EntityNotFoundException extends DomainException {
    private static final String formattedMessage = "식별자 %s을(를) 통해 %s을(를) 찾을 수 없습니다. 데이터베이스에 존재하지 않을 가능성이 있습니다.";
    public EntityNotFoundException(Class<?> entityType, Object key) {
        super(ErrorCode.ID_NOT_FOUND, String.format(formattedMessage, key, entityType.getSimpleName()));
    }
}
