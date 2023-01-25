package com.consenso_backend.model;

import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

@Data
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;
   
    @FutureOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    
    //@JsonFormat(pattern = "hh:MM")
    private LocalTime hora;

    
    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Servico servicos;


    
}
