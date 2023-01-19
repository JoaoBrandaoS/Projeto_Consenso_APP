package com.consenso_backend.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.consenso_backend.model.Usuario;

public interface UsuarioService extends JpaRepository<Usuario, Integer>{
    
}
