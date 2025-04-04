package com.example.auto_market.publicacion.service;

import com.example.auto_market.publicacion.Publicacion;
import com.example.auto_market.publicacion.dto.PublicacionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PublicacionService {
    Page<PublicacionResponseDto> getAllPublicaciones(Pageable pageable);
    PublicacionResponseDto getPublicacionById(Integer id);
    Page<PublicacionResponseDto> getPublicacionesByClienteId(Integer clienteId,Pageable pageable);

}
