package com.consenso_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.consenso_backend.model.Usuario;
import com.consenso_backend.service.UsuarioService;


@RestController
public class UsuarioController {
    
@PostMapping("/usuario")
public ResponseEntity<Object> criarNovoUsuario(@RequestBody Usuario usuario) {
        
    if (usuario.getTipoUsuario().getIdTipoUsuario() == 1 || usuario.getTipoUsuario().getIdTipoUsuario() == 2) {
        usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuario.getTipoUsuario().getNome());

}

@GetMapping("/usuario")
public List<Usuario> usuariosRegistrados(){
    return usuarioService.findAll();
}

@GetMapping("/usuario/{id}")
public Usuario usuarioRegistradoPorId(@PathVariable("id") Integer id){
    return usuarioService.findById(id).get();
}

@DeleteMapping("/usuario/{id}")
public String deletarUsuario(@PathVariable("id") Integer id){
    usuarioService.deleteById(id);

    return "Usuario deletado com sucesso!!";
}

@PutMapping("/usuario")
public Usuario atualizarUsuario(@RequestBody Usuario usuario){
    Usuario usuarioBD = usuarioService.findById(usuario.getIdUsuario()).get();

    usuarioBD.setNome(usuario.getNome()); 
    usuarioBD.setSobrenome(usuario.getSobrenome());
    usuarioBD.setEmail(usuario.getEmail());
    usuarioBD.setSenha(usuario.getSenha());

    usuarioBD = usuarioService.save(usuarioBD);

    return usuarioBD; 

}



@Autowired
private UsuarioService usuarioService;

}
