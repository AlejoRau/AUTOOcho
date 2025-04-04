package com.example.auto_market.valoracion.mappers;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.dto.ClienteResponseDto;
import com.example.auto_market.valoracion.Valoracion;
import com.example.auto_market.valoracion.dto.ValoracionResponseDto;

public class ValoracionMappers {

    public static ValoracionResponseDto toValoracionResponseDto(Valoracion valoracion) {

        if (valoracion == null) return null;
        return ValoracionResponseDto.builder()
                .id(valoracion.getId())
                .valoracion(valoracion.getValoracion())
                .comentario(valoracion.getComentario())
                .clienteVotante(toClienteResponseDto(valoracion.getClienteVotante()))
                .clienteValorado(toClienteResponseDto(valoracion.getClienteValorado()))
                .build();
    }

    public static ClienteResponseDto toClienteResponseDto(Cliente cliente) {
        if (cliente == null) return null;
        return ClienteResponseDto.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .profileImgUrl(cliente.getProfileImgUrl())
                .build();
    }



}
