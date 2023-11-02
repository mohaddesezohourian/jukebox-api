package com.example.jukebox.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ErrorResponse {

    int code;
    String message;

    public ErrorResponse(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }

    public static final ErrorResponse ItemNotFound = new ErrorResponse(HttpStatus.CONFLICT, "the item you looking for is not found!");
    public static final ErrorResponse ServiceUnavailable = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, "service unavailable");


}
