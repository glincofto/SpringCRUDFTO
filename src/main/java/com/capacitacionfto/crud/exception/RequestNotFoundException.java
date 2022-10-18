package com.capacitacionfto.crud.exception;

import java.util.List;

public class RequestNotFoundException extends ApiRequestException{

    public RequestNotFoundException(String message) {
        super(message);
    }

    public RequestNotFoundException(String errorMessage, List<String> errors) {
        super(errorMessage, errors);
    }
}
