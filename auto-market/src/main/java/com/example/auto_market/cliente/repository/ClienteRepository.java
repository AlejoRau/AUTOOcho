package com.example.auto_market.cliente.repository;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.cliente.dto.ClienteResponseDto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByEmail(String email); 
    boolean existsClienteByEmail(String email);
    boolean existsById(Integer id);
    @Query("SELECT c.rol.tipo FROM Cliente c WHERE c.email = :email")
    Optional<String> findRolByEmail(String email);
}
