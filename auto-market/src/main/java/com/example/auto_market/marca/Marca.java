package com.example.auto_market.marca;


import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.publicacion.Publicacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre",unique = true, nullable = false)
    private String nombre;

    @Column(name = "cantidad_publicaciones")
    private int cantidadPubliaciones;

    @OneToMany(mappedBy = "marca")
    private List<Publicacion> publicaciones;


}
