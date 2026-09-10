package com.danidevbank.demo.service;

import java.util.List;

import com.danidevbank.demo.dto.request.TransferRequest;
import com.danidevbank.demo.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse trasnfer(TransferRequest request,  String currentUserEmail);
    List<TransactionResponse> getAccountHistory(String accountNumber, String currentuserEmail);

}
