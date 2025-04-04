package com.example.auto_market.favorito.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.auto_market.favorito.Favorito;
import com.example.auto_market.favorito.dto.FavoritoResponseDto;
import com.example.auto_market.favorito.mappers.favoritoMapper;
import com.example.auto_market.favorito.repository.favoritoRepository;

@Service
public class FavoritoService {

    @Autowired 
    favoritoRepository favoritoRepository ; 
    
    public List<FavoritoResponseDto> GetFavoritosByCliente(Integer idCliente) {
        try {
            List<Favorito> favoritos = favoritoRepository.findByClienteId(idCliente);
            return favoritos.stream()
                    .map(favoritoMapper::toFavoritoResponseDto)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los favoritos del cliente con ID: " + idCliente, e);
        }
    }
    }
    

