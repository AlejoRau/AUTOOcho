package com.example.auto_market.publicacion.mappers;

import com.example.auto_market.publicacion.Publicacion;
import com.example.auto_market.publicacion.dto.PublicacionResponseDto;
import com.example.auto_market.publicacion.imagenes.mappers.PublicacionImagenMappers;
import org.springframework.beans.factory.annotation.Autowired;


public class PublicacionMappers {


    public static PublicacionResponseDto toPublicacionResponseDto(Publicacion publicacion){

        return PublicacionResponseDto
                .builder()
                .id(publicacion.getId())
                .anio(publicacion.getAnio())
                .color(publicacion.getColor())
                .destacado(publicacion.isDestacado())
                .kilometraje(publicacion.getKilometraje())
                .marca(publicacion.getMarca().getNombre())
                .modelo(publicacion.getModelo())
                .precio(publicacion.getPrecio())
                .urlImagenes(
                        publicacion.getImagenes().stream().map(PublicacionImagenMappers::toPublicacionImagenResponseDto).toList()
                )
                .tipo_combustible(publicacion.getTipoCombustible())
                .build();

    }

}
