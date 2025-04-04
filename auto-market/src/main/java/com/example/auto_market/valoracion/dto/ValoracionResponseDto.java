package com.example.auto_market.valoracion.dto;

import com.example.auto_market.cliente.dto.ClienteResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionResponseDto {
    private int id;
    private int valoracion;
    private String comentario;
    private ClienteResponseDto clienteValorado;
    private ClienteResponseDto clienteVotante;
}
