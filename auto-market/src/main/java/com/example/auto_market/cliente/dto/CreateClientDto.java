package com.example.auto_market.cliente.dto;

import jakarta.validation.constraints.*;


public record CreateClientDto(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres")
        String nombre,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(max = 50, message = "El apellido no puede exceder los 50 caracteres")
        String apellido,

        @NotNull(message = "El teléfono es obligatorio") // Cambiado de @NotBlank a @NotNull
        @Min(value = 10000000, message = "El teléfono debe tener al menos 8 dígitos")
        @Max(value = 999999999, message = "El teléfono no puede exceder los 9 dígitos")
        Integer telefono,

        @NotBlank(message = "El correo electrónico es obligatorio")
        @Email(message = "El formato del correo electrónico es inválido")
        @Size(max = 100, message = "El correo electrónico no puede exceder los 100 caracteres")
        String email,

        @NotBlank(message = "La contraseña  es obligatoria")
        @Size(min=8 ,max = 40, message = "La contraseña debe estar entre 8 y 40 caracteres")
        String contrasena,

        @NotBlank(message = "La ciudad es obligatoria")
        @Size(max = 50, message = "La ciudad no puede exceder los 50 caracteres")
        String ciudad

        
) {

}
