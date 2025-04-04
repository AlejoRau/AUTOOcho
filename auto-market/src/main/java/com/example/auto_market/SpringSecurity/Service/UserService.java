package com.example.auto_market.SpringSecurity.Service;



import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auto_market.cliente.dto.ClienteResponseCompleto;
import com.example.auto_market.cliente.dto.ClienteResponseDto;
import com.example.auto_market.cliente.dto.CreateClientDto;
import com.example.auto_market.cliente.service.ClienteService;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    @Autowired
    ClienteService clienteService ;
    
    private final PasswordEncoder passwordEncoder;

    public ClienteResponseDto saveUser(CreateClientDto createClientDto) throws Exception {
        try{ 
            CreateClientDto clientDto = new CreateClientDto(
                createClientDto.nombre(),
                createClientDto.apellido(),
                createClientDto.telefono(),
                createClientDto.email(),
                passwordEncoder.encode(createClientDto.contrasena()), 
                createClientDto.ciudad()
                ) ;
               
                   final var result =  clienteService.newClient(clientDto);
        return new ClienteResponseDto(result.getId(),result.getNombre(),result.getApellido());


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}