package com.danidevbank.demo.dto.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {
    @NotBlank(message = "La cuenta de origen es requerida")
    private String  sourceAccountNumber;

    @NotBlank(message = "La cuenta de destino es requerida")
    private String destinationAccountNumber;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value= "0.01", message=" El monto debe ser superior a cero (0)")
    private BigDecimal amount;
    
    private String description;
}
