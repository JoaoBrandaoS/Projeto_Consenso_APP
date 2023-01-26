package com.consenso_backend.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.consenso_backend.model.Agendamento;

public interface AgendamentoService extends JpaRepository<Agendamento, Integer> {
    @Query("SELECT a FROM Agendamento a WHERE a.usuario = :id")
     List<Agendamento>findByIdUsuario(@Param("id") Integer id);

}
