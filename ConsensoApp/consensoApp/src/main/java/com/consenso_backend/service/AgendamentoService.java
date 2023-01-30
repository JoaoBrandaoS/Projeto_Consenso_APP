package com.consenso_backend.service;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;



import com.consenso_backend.model.Agendamento;

public interface AgendamentoService extends JpaRepository<Agendamento, Integer> {
   
    List<Agendamento>findByusuarioIdUsuario(Integer idUsuario);
    Optional<Agendamento>findByIdAgendamento(Integer id);

}
