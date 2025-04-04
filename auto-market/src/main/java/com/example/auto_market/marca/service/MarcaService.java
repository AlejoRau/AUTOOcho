package com.example.auto_market.marca.service;

import com.example.auto_market.marca.Marca;
import com.example.auto_market.marca.dto.MarcaResponseDto;

import java.util.List;

public interface MarcaService {
    List<MarcaResponseDto> getAllMarcas();
}
