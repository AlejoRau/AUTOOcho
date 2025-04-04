package com.example.auto_market.SpringSecurity.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.auto_market.cliente.dto.ClienteResponseDto;

import com.example.auto_market.SpringSecurity.Service.UserService;
import com.example.auto_market.cliente.dto.ClienteResponseCompleto;
import com.example.auto_market.cliente.dto.ClienteResponseDto;
import com.example.auto_market.cliente.dto.CreateClientDto;


    
@RestController
@RequestMapping("/api/registro")
public class RegisterController {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid CreateClientDto clientDto) {
        try {
            ClienteResponseDto  c = userService.saveUser(clientDto);

            return new ResponseEntity<>(c.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            
            return new ResponseEntity<>("Error al guardar el usuario: "  + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
