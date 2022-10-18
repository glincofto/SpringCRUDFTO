package com.capacitacionfto.crud.exception;

import java.util.List;

public class RequestValidationException extends  ApiRequestException{
    public RequestValidationException(String message) {
        super(message);
    }

    public RequestValidationException(String errorMessage, List<String> errors) {
        super(errorMessage, errors);
    }
}
