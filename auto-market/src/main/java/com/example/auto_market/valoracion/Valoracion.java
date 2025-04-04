package com.example.auto_market.valoracion;

import com.example.auto_market.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "valoracion")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valoracion")
    private int valoracion;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_cliente_votante",nullable = false)
    private Cliente clienteVotante;

    @ManyToOne
    @JoinColumn(name = "id_cliente_valorado")
    private Cliente clienteValorado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Cliente getClienteVotante() {
        return clienteVotante;
    }

    public void setClienteVotante(Cliente idClienteVotante) {
        this.clienteVotante = idClienteVotante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Cliente getClienteValorado() {
        return clienteValorado;
    }

    public void setClienteValorado(Cliente idClienteValorado) {
        this.clienteValorado = idClienteValorado;
    }
}
