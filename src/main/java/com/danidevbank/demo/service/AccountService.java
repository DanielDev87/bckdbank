package com.danidevbank.demo.service;

import java.util.List;

import com.danidevbank.demo.dto.response.AccountResponse;

public interface AccountService {
    List<AccountResponse> getUserAccounts(String email);
    AccountResponse getAccountByNumber(String accountNumber, String email);

}
