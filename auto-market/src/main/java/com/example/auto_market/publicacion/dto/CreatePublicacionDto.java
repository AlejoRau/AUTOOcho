package com.example.auto_market.publicacion.dto;

import com.example.auto_market.marca.Marca;
import com.example.auto_market.publicacion.enums.TipoTransmision;
import com.example.auto_market.publicacion.enums.tipoCombustible;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreatePublicacionDto(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 40, message = "El nombre no puede exceder los 40 caracteres")
        String titulo,

        @NotBlank(message = "El color es obligatorio")
        @Size(max = 20, message = "El color no puede exceder los 20 caracteres")
        String color,

        @NotBlank
        @Positive
        @Size(max = 40)
        Integer kilometraje,

        @NotNull(message = "El modelo es obligatorio")
        @Size(max = 40, message = "El modelo no puede exceder los 40 caracteres" ) 
        String modelo,

        @NotBlank(message = "El combustible es obligatorio")
        tipoCombustible tipoCombustible,

        @NotBlank(message = "La contraseña  es obligatoria")
        @Size(min=8 ,max = 40, message = "La contraseña debe estar entre 8 y 40 caracteres")
        String contrasena,

        @NotBlank(message = "La transmision es obligatoria")
        @Size(max = 20, message = "La transmision no puede exceder los 20 caracteres")
        TipoTransmision tipoTransmision,

       
        @Positive
        @Min(value = 1960, message = "El año no puede ser menor a 1960")
        @Max(value = 2025, message = "El año no puede ser mayor a 2025")
        Integer anio,

        @NotBlank()
        @Size (max = 40, message= "EL modelo no puede exceder los 40 caracteres") 
        Integer idMarca

        

   

        
) {

}
