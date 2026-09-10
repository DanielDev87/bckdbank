package com.danidevbank.demo.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danidevbank.demo.dto.response.AccountResponse;
import com.danidevbank.demo.service.AccountService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api/v1/accounts") 
@RequiredArgsConstructor 
public class AccountController {

    private final AccountService accountService;

    @GetMapping      
    public ResponseEntity<List<AccountResponse>> getMyAccounts(Authentication authentication){
        return ResponseEntity.ok(accountService.getUserAccounts(authentication.getName()));

    }

    @GetMapping("/{accountnumber}") 
     public ResponseEntity<AccountResponse> getAccountBynNmber(
        @PathVariable String accountNumber,
        Authentication authentication ){
        return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber,authentication.getName()));
    }

}
