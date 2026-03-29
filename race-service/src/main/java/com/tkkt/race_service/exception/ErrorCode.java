package com.tkkt.race_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXISTS(1002, "Username already exists", HttpStatus.BAD_REQUEST),
    USERNAME_NOT_FOUND(1003, "Username not found", HttpStatus.BAD_REQUEST),
    PASSWORD_MISMATCH(1004, "Password mismatch", HttpStatus.BAD_REQUEST),
    NOT_FOUND_RACE(1005, "Race not found", HttpStatus.BAD_REQUEST)
    ;
    private final int code;
    private final String message;
    private final HttpStatus statusCode ;
}
