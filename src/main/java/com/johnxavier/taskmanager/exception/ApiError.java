package com.johnxavier.taskmanager.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Getter
@Setter
public class ApiError {

    private HttpStatusCode statusCode;
    private List<String> errors;

    public ApiError(HttpStatusCode statusCode, List<String> errors) {
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public ApiError(HttpStatusCode statusCode, String error) {
        this.statusCode = statusCode;
        this.errors = List.of(error);
    }
}
