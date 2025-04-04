package com.example.auto_market.publicacion.imagenes.repostirory;

import com.example.auto_market.publicacion.imagenes.PublicacionImagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionImagenRepository extends JpaRepository<PublicacionImagen,Integer> {

    List<PublicacionImagen> getAllByPublicacionId(Integer publicacionId);

}
