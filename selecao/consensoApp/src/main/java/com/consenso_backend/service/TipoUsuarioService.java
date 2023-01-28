package com.consenso_backend.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.consenso_backend.model.TipoUsuario;

public interface TipoUsuarioService extends JpaRepository<TipoUsuario,Integer> {
    
    Optional<TipoUsuario>findByIdTipoUsuario(Integer id);

}
