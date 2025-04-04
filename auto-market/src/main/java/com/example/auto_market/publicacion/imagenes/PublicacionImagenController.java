package com.example.auto_market.publicacion.imagenes;

import com.example.auto_market.publicacion.imagenes.dto.PublicacionImagenResponseDto;
import com.example.auto_market.publicacion.imagenes.service.PublicacionImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/publicaciones/imagenes")
public class PublicacionImagenController {

    @Autowired
    private PublicacionImagenesService publicacionImagenesService;

    @GetMapping
    public List<PublicacionImagenResponseDto> getPublicacionImagenes(){
        return publicacionImagenesService.getAllPublicacionImagenes();
    }
}
