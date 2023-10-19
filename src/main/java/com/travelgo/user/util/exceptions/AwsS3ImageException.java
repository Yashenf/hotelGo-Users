package com.travelgo.user.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AwsS3ImageException extends RuntimeException{
    public AwsS3ImageException(String message){
        super(message);
    }
}
