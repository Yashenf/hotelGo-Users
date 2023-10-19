package com.travelgo.user.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message){
        super(message);
    }
}
