package com.example.auto_market.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Rol {
    @Id
    private int Id ; 
   private String tipo ; 
}