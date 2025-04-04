package com.example.auto_market.cliente.dto;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {
    private int id;
    private String nombre;
    private String apellido;
    @Nullable
    private String profileImgUrl;

    public ClienteResponseDto(int id , String nombre , String apellido){
        this.id = id ;
        this.nombre = nombre;
        this.apellido = apellido ; 
    }
}


