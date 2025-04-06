package com.example.auto_market.publicacion.service;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.repository.ClienteRepository;
import com.example.auto_market.publicacion.dto.CreatePublicacionDto;
import com.example.auto_market.publicacion.dto.PublicacionResponseDto;
import com.example.auto_market.publicacion.mappers.PublicacionMappers;
import com.example.auto_market.publicacion.repository.PublicacionRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class PublicacionServiceImpl implements PublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Page<PublicacionResponseDto> getAllPublicaciones(Pageable pageable) {

        Page<PublicacionResponseDto> publicaciones =  publicacionRepository.findAll(pageable).map(PublicacionMappers::toPublicacionResponseDto);

        return publicaciones;
    }

    @Override
    public PublicacionResponseDto getPublicacionById(Integer id) {

        return publicacionRepository.findById(id)
                .map(PublicacionMappers::toPublicacionResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("No existe la publicación con ID: " + id));

    }

    @Override
    public Page<PublicacionResponseDto> getPublicacionesByClienteId( Integer clienteId,Pageable pageabe ) {

        if(!clienteRepository.existsById(clienteId)){
            throw new EntityNotFoundException("No existe el cliente con ID: " + clienteId);
        }


        return publicacionRepository.getPublicacionesByClienteId(clienteId,pageabe).map(PublicacionMappers::toPublicacionResponseDto);
    }

    @Override
    public PublicacionResponseDto createPublicacion(CreatePublicacionDto datos, List<MultipartFile> imagenes) {
        try {
             Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         String email = authentication.getName();

        Cliente cliente = clienteRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + email));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
