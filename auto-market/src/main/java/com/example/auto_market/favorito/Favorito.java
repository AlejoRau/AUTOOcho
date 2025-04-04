package com.example.auto_market.favorito;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.publicacion.Publicacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "publicacion_id",nullable = false)
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "cliente_id" , nullable = false)
    private Cliente cliente;

}
