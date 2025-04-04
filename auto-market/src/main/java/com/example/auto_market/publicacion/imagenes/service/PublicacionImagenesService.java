package com.example.auto_market.publicacion.imagenes.service;

import com.example.auto_market.publicacion.imagenes.PublicacionImagen;
import com.example.auto_market.publicacion.imagenes.dto.PublicacionImagenResponseDto;

import java.util.List;

public interface PublicacionImagenesService {
    List<PublicacionImagenResponseDto> getAllPublicacionImagenes();

    List<PublicacionImagenResponseDto> getAllImagenesByPublicacionId(Integer id);
}
