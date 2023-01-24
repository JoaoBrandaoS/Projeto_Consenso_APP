package com.consenso_backend.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.consenso_backend.model.TipoUsuario;

public interface TipoUsuarioService extends JpaRepository<TipoUsuario,Integer> {
    
    Optional<TipoUsuario> findById(Integer id);

}
