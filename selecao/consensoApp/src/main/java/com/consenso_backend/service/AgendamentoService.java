package com.consenso_backend.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consenso_backend.model.Agendamento;

public interface AgendamentoService extends JpaRepository<Agendamento, Integer> {
   

}
