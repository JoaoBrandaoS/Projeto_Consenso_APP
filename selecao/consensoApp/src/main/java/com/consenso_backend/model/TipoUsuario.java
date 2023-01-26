package com.consenso_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TipoUsuario {
    
    @Id
    @Column(name = "TIPOUSUARIO_IDTIPOUSUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoUsuario;
     
    private String nome;

}
