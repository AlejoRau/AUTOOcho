package com.example.auto_market.favorito.mappers;

import com.example.auto_market.favorito.Favorito;
import com.example.auto_market.favorito.dto.FavoritoResponseDto;
import com.example.auto_market.publicacion.Publicacion;

public class favoritoMapper {

    public static FavoritoResponseDto toFavoritoResponseDto(Favorito favorito) {
        FavoritoResponseDto dto = new FavoritoResponseDto();

        dto.setId(favorito.getId());
        dto.setIdCliente(favorito.getCliente().getId());
        dto.setIdPublicacion(favorito.getPublicacion().getId());

        
        Publicacion publicacion = favorito.getPublicacion();

        dto.setTituloPublicacion(publicacion.getTitulo());
        dto.setPrecio(publicacion.getPrecio());

        
        String imagenPrincipal = null;
        if (publicacion.getImagenes() != null && !publicacion.getImagenes().isEmpty()) {
            imagenPrincipal = publicacion.getImagenes().get(0).getImagen(); 
        }
        dto.setImagenPrincipal(imagenPrincipal);

        return dto;
    }
}

