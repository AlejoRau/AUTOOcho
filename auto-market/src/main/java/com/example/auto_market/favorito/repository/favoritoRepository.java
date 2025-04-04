package com.example.auto_market.favorito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auto_market.favorito.Favorito;

@Repository
public interface favoritoRepository extends JpaRepository<Favorito, Integer> {

    List<Favorito> findByClienteId(Integer idCliente);
    
}
