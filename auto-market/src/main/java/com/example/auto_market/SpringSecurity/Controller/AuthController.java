package com.example.auto_market.SpringSecurity.Controller;

import com.example.auto_market.SpringSecurity.DTO.LoginDto;
import com.example.auto_market.SpringSecurity.Security.JWT.jwtFilter;
import com.example.auto_market.SpringSecurity.Security.JWT.jwtService;
import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.dto.ClienteResponseCompleto;
import com.example.auto_market.cliente.dto.ClienteResponseDto;
import com.example.auto_market.cliente.service.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/authenticate")
@RequiredArgsConstructor
public class AuthController {

    private final jwtService jwtService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> authorize(@Valid @RequestBody LoginDto request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String jwt = jwtService.createToken(authentication);
        
        String rol = clienteService.getRolByEmail(request.getEmail());
        

        Map<String, Object> response = new HashMap<>();
        response.put("token", jwt);
        response.put("rol", rol);
        response.put("email", request.getEmail());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(jwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }
}