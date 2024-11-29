package com.school.teacher_ms.exception;


import lombok.Getter;


@Getter
public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }
}
