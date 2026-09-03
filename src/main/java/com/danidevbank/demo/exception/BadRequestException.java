package com.danidevbank.demo.execption;

public class BadRequestException  extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }

}
