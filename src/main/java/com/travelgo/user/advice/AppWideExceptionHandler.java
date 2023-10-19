package com.travelgo.user.advice;


import com.travelgo.user.util.StandardResponse;
import com.travelgo.user.util.exceptions.AwsS3ImageException;
import com.travelgo.user.util.exceptions.DuplicateDataException;
import com.travelgo.user.util.exceptions.EntryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFound(EntryNotFoundException exception){
        return new ResponseEntity(
                new StandardResponse(
                        404,
                        exception.getMessage(),
                        "Not Found"
                ), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AwsS3ImageException.class)
    public ResponseEntity<StandardResponse> handleImageException(AwsS3ImageException exception){
        return new ResponseEntity(
                new StandardResponse(
                        404,
                        exception.getMessage(),
                        "Something went wrong. check internet connection and AWS Credentials"
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<StandardResponse> handleDuplicates(DuplicateDataException exception){
        return new ResponseEntity(
                new StandardResponse(
                        400,
                        exception.getMessage(),
                        exception.getMessage()+" Duplicate Entry. Already Have AnAccount or Recode. You Can Update It."
                ), HttpStatus.BAD_REQUEST
        );
    }
}