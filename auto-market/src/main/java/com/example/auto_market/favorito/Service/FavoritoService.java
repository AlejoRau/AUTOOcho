package com.example.auto_market.favorito.Service;

import java.util.List;

import com.example.auto_market.favorito.dto.FavoritoResponseDto;

public interface FavoritoService {

    public List<FavoritoResponseDto> GetFavoritosByCliente(); 
    public void DeleteFavoritoById(Integer idFavorito);
    public FavoritoResponseDto AgregarFavorito(Integer idPublicacion);
} 
    

