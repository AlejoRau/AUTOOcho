package com.example.auto_market.publicacion.imagenes.service;

import com.example.auto_market.publicacion.imagenes.PublicacionImagen;
import com.example.auto_market.publicacion.imagenes.dto.PublicacionImagenResponseDto;
import com.example.auto_market.publicacion.imagenes.mappers.PublicacionImagenMappers;
import com.example.auto_market.publicacion.imagenes.repostirory.PublicacionImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionImagenesServiceImpl implements PublicacionImagenesService{

    @Autowired
    private PublicacionImagenRepository publicacionImagenRepository;

    @Override
    public List<PublicacionImagenResponseDto> getAllPublicacionImagenes() {
        return publicacionImagenRepository
                .findAll()
                .stream()
                .map(PublicacionImagenMappers::toPublicacionImagenResponseDto).toList();
    }

    @Override
    public List<PublicacionImagenResponseDto> getAllImagenesByPublicacionId(Integer id) {
        return publicacionImagenRepository.getAllByPublicacionId(id).stream().map(PublicacionImagenMappers::toPublicacionImagenResponseDto).toList();
    }


}
