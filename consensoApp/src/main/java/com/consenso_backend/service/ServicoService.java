package com.consenso_backend.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consenso_backend.model.Servico;

public interface ServicoService extends JpaRepository<Servico,Integer>{

    List<Servico>findServicoByusuarioIdUsuario(Integer idusuario);
    
}
