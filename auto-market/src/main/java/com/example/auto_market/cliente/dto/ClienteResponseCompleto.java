package com.example.auto_market.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseCompleto extends ClienteResponseDto {
    private String profileBannerUrl;
    private String email;
    private int telefono;
    private String ciudad;
    
}