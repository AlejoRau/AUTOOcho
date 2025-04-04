package com.example.auto_market.SpringSecurity.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    

    @NotEmpty(message = "el campo Email no puede estar vacio")
    private String email; 
    @NotNull( message = "La contraseña es obligatoria.")
    private String password;
}