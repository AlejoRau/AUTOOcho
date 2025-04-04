package com.example.auto_market.cliente.mappers;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.dto.ClienteResponseCompleto;
import com.example.auto_market.cliente.dto.CreateClientDto;

public class ClienteMappers {


    public static ClienteResponseCompleto toClienteResponseCompleto(Cliente cliente)
    {
        return ClienteResponseCompleto.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .profileImgUrl(cliente.getProfileImgUrl())
                .profileBannerUrl(cliente.getBannerImgUrl())
                .email(cliente.getEmail())
                .ciudad(cliente.getCiudad())
                .telefono(cliente.getTelefono())
                .build();
    }


    public static Cliente toCliente(CreateClientDto createClientDto){

        return Cliente.builder()
                .email(createClientDto.email())
                .nombre(createClientDto.nombre())
                .apellido(createClientDto.apellido())
                .telefono(createClientDto.telefono())
                .ciudad(createClientDto.ciudad())
                .build();

    }
}
