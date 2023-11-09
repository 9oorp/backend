package com.goorp.backend.exception;

import com.goorp.backend.dto.ApiErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler
    public ApiErrorResponseDto runtimeExceptionHandler(MemberException e) {
        return ApiErrorResponseDto.builder()
            .ok(false)
            .errorMessage(e.getMessage())
            .build();
    }

    @ExceptionHandler
    public ApiErrorResponseDto runtimeExceptionHandler(PostException e) {
        return ApiErrorResponseDto.builder()
            .ok(false)
            .errorMessage(e.getMessage())
            .build();
    }

    @ExceptionHandler
    public ApiErrorResponseDto runtimeExceptionHandler(CommentException e) {
        return ApiErrorResponseDto.builder()
            .ok(false)
            .errorMessage(e.getMessage())
            .build();
    }

    @ExceptionHandler
    public ApiErrorResponseDto processValidationError(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String firstErrorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
        return ApiErrorResponseDto.builder()
            .ok(false)
            .errorMessage(firstErrorMessage)
            .build();
    }
}