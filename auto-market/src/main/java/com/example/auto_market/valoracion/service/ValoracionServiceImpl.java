package com.example.auto_market.valoracion.service;

import com.example.auto_market.valoracion.Valoracion;
import com.example.auto_market.valoracion.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionServiceImpl implements ValoracionService{

    @Autowired
    ValoracionRepository valoracionRepository;

    @Override
    public List<Valoracion> getAllValoraciones() {
        return valoracionRepository.findAll();
    }
}
