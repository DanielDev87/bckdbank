package com.danidevbank.demo.service.impl;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.danidevbank.demo.dto.request.TransferRequest;
import com.danidevbank.demo.dto.response.TransactionResponse;
import com.danidevbank.demo.entity.Account;
import com.danidevbank.demo.repository.AccountRepository;
import com.danidevbank.demo.repository.TransactionRepository;
import com.danidevbank.demo.service.TransactionService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionResponse transfer(TransferRequest request, String currentuserEmail){
        if (request.getSourceAccountNumber().equals(request.getDestinationAccountNumber())) {
            throw new BadRequestException("La cuenta de origen y la de destino nopueden ser la misma");      
        
        }
        //1 validar cuenta de origen
    Account sourceAccount = accountRepository.findByAccountNumber(request.getSourceAccountNumber())
    }
    
    //2. Validar que la cuenta de origen pertenezca al usuario logueado

    //3.Validar la cuenta de destino
     
    //4.Validar que exista saldo suficiente

    //5.Actualizacion de saldos en ambas partes

    //6.Registrar la transaccion en ambos

}
