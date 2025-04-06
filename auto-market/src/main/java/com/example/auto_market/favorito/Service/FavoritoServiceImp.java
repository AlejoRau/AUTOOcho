package com.example.auto_market.favorito.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.repository.ClienteRepository;
import com.example.auto_market.favorito.Favorito;
import com.example.auto_market.favorito.dto.FavoritoResponseDto;
import com.example.auto_market.favorito.mappers.favoritoMapper;
import com.example.auto_market.favorito.repository.favoritoRepository;
import com.example.auto_market.publicacion.Publicacion;
import com.example.auto_market.publicacion.repository.PublicacionRepository;

@Service
public class FavoritoServiceImp implements FavoritoService{

    @Autowired 
    favoritoRepository favoritoRepository ; 
     @Autowired
    ClienteRepository clienteRepository ;
    @Autowired
    PublicacionRepository publicacionRepository ;
    
    public List<FavoritoResponseDto> GetFavoritosByCliente() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            
        Cliente cliente = clienteRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + email));
            List<Favorito> favoritos = favoritoRepository.findByClienteId(cliente.getId());
            return favoritos.stream()
                    .map(favoritoMapper::toFavoritoResponseDto)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los favoritos del cliente " , e);
        }
    }

    public void DeleteFavoritoById(Integer idFavorito) {
          try {
            if (this.favoritoRepository.existsById(idFavorito)) {
                this.favoritoRepository.deleteById(idFavorito);
            } else
                 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorito con ID: " + idFavorito + " no encontrado");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public FavoritoResponseDto AgregarFavorito(Integer idPublicacion) {
        try{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         String email = authentication.getName();

        Cliente cliente = clienteRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + email));

     Publicacion publicacion = publicacionRepository.findById(idPublicacion)
    .orElseThrow(() -> new RuntimeException("No se encontró la publicación"));

    Favorito favorito = Favorito.builder()
    .cliente(cliente)
    .publicacion(publicacion)
    .build();
            favoritoRepository.save(favorito);
            return favoritoMapper.toFavoritoResponseDto(favorito);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    }
    
    

