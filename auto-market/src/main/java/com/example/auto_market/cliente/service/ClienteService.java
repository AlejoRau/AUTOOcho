package com.example.auto_market.cliente.service;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.dto.ClienteResponseDto;
import com.example.auto_market.cliente.dto.CreateClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ClienteService {
    Page<Cliente> getAllClientes(Pageable pageable);
    ClienteResponseDto getClienteByEmail(String email);
    Cliente newClient(CreateClientDto createClientDto);
    String getRolByEmail(String email);
    
}
