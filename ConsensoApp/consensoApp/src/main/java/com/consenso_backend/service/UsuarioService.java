package com.consenso_backend.service;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consenso_backend.model.Usuario;

public interface UsuarioService extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario>findById(Integer id);
    
    Optional<Usuario>findByemail(String email);

    Optional<Usuario>findByIdUsuario(Integer id);

}
