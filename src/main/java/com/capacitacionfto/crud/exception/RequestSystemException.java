package com.capacitacionfto.crud.exception;

import java.util.List;

public class RequestSystemException extends ApiRequestException{
    public RequestSystemException(String message) {
        super(message);
    }

    public RequestSystemException(String errorMessage, List<String> errors) {
        super(errorMessage, errors);
    }
}
