package com.danidevbank.demo.execption;

public class InsuffienteBalanceException extends RuntimeException {
    public InsuffienteBalanceException(String message){
        super(message);
    }

}
