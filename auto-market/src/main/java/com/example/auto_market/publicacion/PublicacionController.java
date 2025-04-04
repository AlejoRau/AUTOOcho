package com.example.auto_market.publicacion;

import com.example.auto_market.cliente.dto.ClienteResponseCompleto;
import com.example.auto_market.cliente.mappers.ClienteMappers;
import com.example.auto_market.publicacion.dto.PublicacionResponseDto;
import com.example.auto_market.publicacion.mappers.PublicacionMappers;
import com.example.auto_market.publicacion.repository.PublicacionRepository;
import com.example.auto_market.publicacion.service.PublicacionService;
import com.example.auto_market.responses.ApiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<Page<PublicacionResponseDto>>> getPublicaciones(Pageable pageable){

        Page<PublicacionResponseDto> publicaciones = publicacionService.getAllPublicaciones(pageable);

        return  ResponseEntity.ok(
                ApiResponseDto.<Page<PublicacionResponseDto>>builder()
                        .error(false)
                        .status(200)
                        .message("Publicaciones encontradas correctamente")
                        .data((publicaciones))
                        .build()
        );
    }

    @GetMapping("/{publicacionId}")
    public ResponseEntity<ApiResponseDto<PublicacionResponseDto>> getPublicacionById(
            @PathVariable Integer publicacionId
    ){

        PublicacionResponseDto publicacion = publicacionService.getPublicacionById(publicacionId);
        return ResponseEntity.ok(
                ApiResponseDto.<PublicacionResponseDto>builder()
                        .data(publicacion)
                        .status(200)
                        .message("Publicación encontrada correctamente")
                        .error(false)
                        .build()
        );

    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<ApiResponseDto<Page<PublicacionResponseDto>>> getPublicacionByUsuarioId(
            @PathVariable("usuarioId") Integer usuarioId,
            Pageable pageable) {
        Page<PublicacionResponseDto> publicaciones = publicacionService.getPublicacionesByClienteId(usuarioId, pageable);
        return ResponseEntity.ok(
                ApiResponseDto.<Page<PublicacionResponseDto>>builder()
                        .data(publicaciones)
                        .message("Publicaciones encontradas correctamente")
                        .error(false)
                        .build()
        );
    }


}
