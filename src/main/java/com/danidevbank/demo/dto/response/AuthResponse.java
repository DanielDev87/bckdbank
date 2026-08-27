package com.danidevbank.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder

public class AuthResponse {
    private String token;
    private String email;
    private String role;
}
