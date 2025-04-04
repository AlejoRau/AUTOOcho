package com.example.auto_market.publicacion.repository;

import com.example.auto_market.marca.Marca;
import com.example.auto_market.publicacion.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion,Integer> {

    @Query(
            value = "SELECT * FROM publicacion p WHERE p.id_cliente = ?1",
            nativeQuery = true
    )
    Page<Publicacion> getPublicacionesByClienteId(Integer clientId,Pageable pageable);



}
