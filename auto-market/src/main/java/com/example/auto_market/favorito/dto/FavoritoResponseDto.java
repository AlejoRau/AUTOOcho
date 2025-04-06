package com.example.auto_market.favorito.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class FavoritoResponseDto {
    private Integer id ;
    private Integer idPublicacion;
    private Integer idCliente ; 

    private String tituloPublicacion;
    private String imagenPrincipal;
    private Double precio;

}
