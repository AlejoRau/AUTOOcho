package com.example.auto_market.publicacion;

import com.example.auto_market.cliente.Cliente;
import com.example.auto_market.favorito.Favorito;
import com.example.auto_market.marca.Marca;
import com.example.auto_market.publicacion.imagenes.PublicacionImagen;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(nullable = false, precision = 10)
    private Double precio;

    @Column(nullable = false)
    private Integer kilometraje;

    @Column(nullable = false, length = 40)
    private String tipoCombustible;

    @Column(nullable = false)
    private Integer anio;

    @Column(name = "tipo_transmision", nullable = false, length = 50)
    private String tipoTransmision;

    @Column(nullable = false, length = 100)
    private String color;

    private boolean destacado;

    @ManyToOne
    @JoinColumn(name = "id_marca",nullable = false)
    private Marca marca;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Favorito> favoritos;

    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PublicacionImagen>imagenes;

}
