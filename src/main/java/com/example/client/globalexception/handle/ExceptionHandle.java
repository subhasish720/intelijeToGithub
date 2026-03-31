package com.example.client.globalexception.handle;

import com.example.client.error.ErrorResponse;
import com.example.client.globalexception.exceptionclass.DataNotFoundException;
import com.example.client.globalexception.exceptionclass.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(IdNotFoundException.class)
     public ResponseEntity<ErrorResponse> idNotFoundExceptionControl(IdNotFoundException e){
          ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "The id is not found in database");
          return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
     }
     @ExceptionHandler(DataNotFoundException.class)
     public ResponseEntity<ErrorResponse> dataNotFoundExceptionHandle(DataNotFoundException e){
          ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "The data is not present in the database");
          return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
     }

}
