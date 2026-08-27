package com.danidevbank.demo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.danidevbank.demo.entity.enums.TransactionType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransactionResponse {
    private Long id;
    private String sourceAccountNumber;
    private String destinationAccount;
    private BigDecimal amount;
    private TransactionType transactionType;
    private String description;
    private LocalDateTime timestamp;
}
