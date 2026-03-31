package com.example.client.globalexception.exceptionclass;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String msg){
        super(msg);
    }
}
