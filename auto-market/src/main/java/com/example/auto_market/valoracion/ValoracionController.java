package com.example.auto_market.valoracion;

import com.example.auto_market.cliente.dto.ClienteResponseDto;
import com.example.auto_market.valoracion.dto.ValoracionResponseDto;
import com.example.auto_market.valoracion.mappers.ValoracionMappers;
import com.example.auto_market.valoracion.service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/valoraciones")
public class ValoracionController {


    @Autowired
    ValoracionService valoracionService;

    @GetMapping
    public List<ValoracionResponseDto> getValoraciones(){
        return valoracionService.getAllValoraciones()
                .stream()
                .map(ValoracionMappers::toValoracionResponseDto).toList();
    }

}
