package com.example.auto_market.marca.service;

import com.example.auto_market.marca.Marca;
import com.example.auto_market.marca.dto.MarcaResponseDto;
import com.example.auto_market.marca.repository.MarcaRepository;
import com.example.auto_market.publicacion.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;


    @Override
    public List<MarcaResponseDto> getAllMarcas() {

        return marcaRepository.findAll().stream().map(
                marca -> MarcaResponseDto
                        .builder()
                        .id(marca.getId())
                        .nombre(marca.getNombre())
                        .cantidadPublicaciones(marca.getCantidadPubliaciones())
                        .build()
        ).toList();
    }
}
