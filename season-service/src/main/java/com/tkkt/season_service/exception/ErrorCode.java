package com.tkkt.season_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    SEASON_NOT_FOUND(1000, "Season not found", HttpStatus.NOT_FOUND),
    ;
    private final int code;
    private final String message;
    private final HttpStatus statusCode ;
}
