package com.capacitacionfto.crud.exception;

import java.util.ArrayList;
import java.util.List;

public class ApiRequestException extends RuntimeException{

    private List<String> errors = new ArrayList<>();

    public ApiRequestException(String message){super(message);}

    public ApiRequestException(String errorMessage, List<String> errors){
        super(errorMessage);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
