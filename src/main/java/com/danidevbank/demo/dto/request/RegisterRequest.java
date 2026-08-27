package com.danidevbank.demo.dto.request;


import lombok.Getter;
import lombok.Setter;
// Pendiente importaciones
@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message="El nombre no puede estar vacío")
    private String firstName;

    @NotBlank(message="El apellido no puede estar vacío")
    private String lastName;

    @Email(message="Debe proporcionar un correo valido")
    @NotBlank(message="El correo no puede estar vacío")
    private String email;

    @Size(min=6, message = "El password  debe tener al menos 6 caracteres")
    @NotBlank(message="El password no puede estar vacío")
    private String password;
}
