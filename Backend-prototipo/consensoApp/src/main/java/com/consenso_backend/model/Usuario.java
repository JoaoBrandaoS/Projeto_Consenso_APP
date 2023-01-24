package com.consenso_backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    @OneToOne
    private TipoUsuario tipoUsuario;

    @OneToOne
    private Servico servicos;

    @OneToOne
    private Agendamento agendamento;

}
