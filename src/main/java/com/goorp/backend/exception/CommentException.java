package com.goorp.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommentException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;
}
