package com.example.auto_market.marca;


import com.example.auto_market.marca.dto.MarcaResponseDto;
import com.example.auto_market.marca.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<MarcaResponseDto> getMarcas() {
        return marcaService.getAllMarcas();
    }

}
