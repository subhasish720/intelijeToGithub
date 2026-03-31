package com.example.client.globalexception.exceptionclass;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String msg){
        super(msg);
    }
}
