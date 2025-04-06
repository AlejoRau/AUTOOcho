package com.example.auto_market.cliente.service;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.Rol;
import com.example.auto_market.cliente.dto.ClienteResponseDto;
import com.example.auto_market.cliente.dto.CreateClientDto;
import com.example.auto_market.cliente.mappers.ClienteMappers;
import com.example.auto_market.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public final static Rol cliente = new Rol (0, "cliente"); 

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Page<Cliente> getAllClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente newClient(CreateClientDto createClientDto) {

        if(clienteRepository.existsClienteByEmail(createClientDto.email())){

            throw new EntityExistsException("El mail ya esta en uso");

        }

        Cliente newCliente = ClienteMappers.toCliente(createClientDto);
        newCliente.setRol(cliente);
        newCliente.setContrasena(passwordEncoder.encode(createClientDto.contrasena()));

        return clienteRepository.save(newCliente);

    }
     @Override
    public ClienteResponseDto getClienteByEmail(String Email){
        return clienteRepository.findByEmail(Email)
        .map(ClienteMappers::toClienteResponseCompleto)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + Email));

    }



    public String getRolByEmail(String Email){
        return clienteRepository.findRolByEmail(Email)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + Email));

    }
}
