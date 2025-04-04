package com.example.auto_market.publicacion.dto;

import com.example.auto_market.publicacion.imagenes.PublicacionImagen;
import com.example.auto_market.publicacion.imagenes.dto.PublicacionImagenResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionResponseDto {

    private int id;
    private String modelo;
    private double precio;
    private int kilometraje;
    private String tipo_combustible;
    private List<PublicacionImagenResponseDto> urlImagenes;
    private int anio;
    private String color;
    private boolean destacado;
    private String marca;

}
