package com.example.auto_market.cliente;

import com.example.auto_market.cliente.dto.ClienteResponseCompleto;

import com.example.auto_market.cliente.dto.CreateClientDto;
import com.example.auto_market.cliente.mappers.ClienteMappers;
import com.example.auto_market.cliente.service.ClienteService;
import com.example.auto_market.responses.ApiResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<Page<ClienteResponseCompleto>>> getClientes(Pageable pageable) {

        Page<ClienteResponseCompleto> clientes = clienteService.getAllClientes(pageable).map(ClienteMappers::toClienteResponseCompleto);

        return ResponseEntity.ok(
                ApiResponseDto.<Page<ClienteResponseCompleto>>builder()
                        .error(false)
                        .data(clientes)
                        .message("Clientes encontrados correctamente")
                        .status(200)
                        .build()
        );

    }


    @PostMapping
    public ResponseEntity<ApiResponseDto<ClienteResponseCompleto>> createClient(
            @Valid @RequestBody CreateClientDto createClientDto
    ){

        Cliente newClient = clienteService.newClient(createClientDto);

        return new ResponseEntity<>(
                ApiResponseDto.<ClienteResponseCompleto>builder()
                        .error(false)
                        .status(201)
                        .message("Usuario creado correctamente")
                        .data(ClienteMappers.toClienteResponseCompleto(newClient))
                        .build(),
                HttpStatus.CREATED
        );
    }


    @GetMapping("/byEmail")
    public ResponseEntity<?> getClienteByEmail(String email) {
       
        try {
                return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.getClienteByEmail(email));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e+"{\"Error. No se pudo ingresar la cuenta, revise los campos e intente nuevamente.\"}");
            }
        }
       

    }

