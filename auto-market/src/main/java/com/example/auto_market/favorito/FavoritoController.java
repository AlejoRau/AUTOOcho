package com.example.auto_market.favorito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.repository.ClienteRepository;
import com.example.auto_market.cliente.service.ClienteService;
import com.example.auto_market.favorito.Service.FavoritoService;
import com.example.auto_market.favorito.dto.FavoritoResponseDto;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {
    @Autowired
    private FavoritoService favoritoService ;

   
    

    @GetMapping("/FavoritosByCliente")
    public ResponseEntity<?> GetFavoritosByCliente(){
        
        try {
            
                List<FavoritoResponseDto> favoritos= favoritoService.GetFavoritosByCliente() ;
                return ResponseEntity.ok(favoritos) ;
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e+"{\"Error. No se pudieron encontrar los favoritos.\"}");
            }
        }
    @DeleteMapping("/{idFavorito}")
    public ResponseEntity<?> DeleteFavoritoById(@PathVariable Integer idFavorito){
        try {
             favoritoService.DeleteFavoritoById(idFavorito) ;
             return ResponseEntity.status(HttpStatus.ACCEPTED).body("{El favorito fue eliminado con exito Eliminado con exito}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e+"{\"Error. No se pudo encontrar el favorito.\"}");
        }
    }

    @PostMapping("{idPublicacion}")
    public ResponseEntity<?>AgregarFavorito (@PathVariable Integer idPublicacion){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(favoritoService.AgregarFavorito(idPublicacion));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e+"{\"Error. No se pudo agregar el favorito.\"}");
       }
    }

    }
    



