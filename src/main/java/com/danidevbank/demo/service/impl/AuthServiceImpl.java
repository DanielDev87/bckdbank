package com.danidevbank.demo.service.impl;

import java.math.BigDecimal;

import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.danidevbank.demo.dto.request.RegisterRequest;
import com.danidevbank.demo.dto.response.AuthResponse;
import com.danidevbank.demo.entity.Account;
import com.danidevbank.demo.entity.User;
import com.danidevbank.demo.entity.enums.AccountType;
import com.danidevbank.demo.entity.enums.Role;
import com.danidevbank.demo.repository.AccountRepository;
import com.danidevbank.demo.repository.UserRepository;
import com.danidevbank.demo.service.AuthService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    @Override 
    @Transactional 
    public AuthResponse register(RegisterRequest request){
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("El correo ya está registrado");
        }
        //1.Crear el usuario
        User user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.ROLE_USER)
        .build();

        User saveduser = userRepository.save(user);
        //2. crear una cuenta por defecto

        Account account = Account.builder()
        .accountNumber(generateAccountNumber())
        .balance(new  BigDecimal("1000"))
        .accountType(AccountType.SAVINGS)
        .user(saveduser)
        .build();

        accountRepository.save(account);
    }
   //Generador de cuentas aleatorias
    private String generateAccountNumber(){
        return "003"+ String.format("%06d", (int) (Math.random() * 1000));
    }
}
