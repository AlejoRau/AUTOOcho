package com.example.auto_market.cliente;

import com.example.auto_market.favorito.Favorito;
import com.example.auto_market.publicacion.Publicacion;
import com.example.auto_market.valoracion.Valoracion;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "cliente",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})

public class Cliente implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre" , nullable = false)
    private String nombre;

    @Column(name = "apellido" , nullable = false)
    private String apellido;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "telefono" , nullable = false)
    private int telefono;

    @Column(name = "contrasena" , nullable = false)
    private String contrasena;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "profile_img_url")
    @Nullable
    private String profileImgUrl;

    @Column(name = "banner_img_url")
    @Nullable
    private String bannerImgUrl;

    @Column(name = "tipo_cliente")
    private String tipoCliente;

    @Nullable
    @OneToMany(mappedBy = "clienteVotante", cascade = CascadeType.ALL)
    private List<Valoracion> valoracionesDadas;

    @Nullable
    @OneToMany(mappedBy = "clienteValorado", cascade = CascadeType.ALL)
    private List<Valoracion> valoracionesRecibidas;


    @Nullable
    @OneToMany(mappedBy = "cliente" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Favorito> favoritos;

    @Nullable
    @OneToMany(mappedBy = "cliente" , cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Publicacion> publicaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rol rol;
 
    @Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(rol.getTipo())); 
}

    @Override
    public String getPassword() {
        return this.contrasena ;
    }

    @Override
    public String getUsername() {
       return this.email ;
    }

}
