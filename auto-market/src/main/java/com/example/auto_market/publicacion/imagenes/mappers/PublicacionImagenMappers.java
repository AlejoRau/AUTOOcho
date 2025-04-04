package com.example.auto_market.publicacion.imagenes.mappers;

import com.example.auto_market.publicacion.imagenes.PublicacionImagen;
import com.example.auto_market.publicacion.imagenes.dto.PublicacionImagenResponseDto;

public class PublicacionImagenMappers {

    public static PublicacionImagenResponseDto toPublicacionImagenResponseDto(PublicacionImagen publicacionImagen){

        return PublicacionImagenResponseDto
                .builder()
                .id(publicacionImagen.getId())
                .url(publicacionImagen.getUrl())
                .createdAt(publicacionImagen.getCreatedAt())
                .build();

    }

}
