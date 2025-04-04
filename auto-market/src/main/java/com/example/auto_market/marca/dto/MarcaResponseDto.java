package com.example.auto_market.marca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaResponseDto {
    private int id;
    private String nombre;
    private int cantidadPublicaciones;
}
