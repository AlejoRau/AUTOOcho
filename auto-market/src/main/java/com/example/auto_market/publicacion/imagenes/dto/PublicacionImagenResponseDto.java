package com.example.auto_market.publicacion.imagenes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicacionImagenResponseDto {
    private int id;
    private String url;
    private LocalDateTime createdAt;
}
