package com.example.auto_market.favorito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auto_market.cliente.service.ClienteService;
import com.example.auto_market.favorito.Service.FavoritoService;
import com.example.auto_market.favorito.dto.FavoritoResponseDto;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {
    @Autowired
    private FavoritoService favoritoService ;
    

    @GetMapping("/GetFavoritosByCliente")
    public ResponseEntity<?> GetFavoritosByCliente(@RequestBody Integer idCliente){
        
        try {
            
                List<FavoritoResponseDto> favoritos= favoritoService.GetFavoritosByCliente(idCliente) ;
                return ResponseEntity.ok(favoritos) ;
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e+"{\"Error. No se pudo encontrar los favoritos.\"}");
            }
        }
       
    }



