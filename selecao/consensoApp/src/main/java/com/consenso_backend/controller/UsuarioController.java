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

    try{

    if(usuario.getTipoUsuario().getIdTipoUsuario() == 1 || usuario.getTipoUsuario().getIdTipoUsuario() == 2){
        usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
   
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuario.getTipoUsuario().getNome());
    
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}

@GetMapping("/usuario")
public List<Usuario> usuariosRegistrados(){
    try{
        return usuarioService.findAll();
    }catch(Exception e){
        return null;
    }

}

@GetMapping("/usuario/{id}")
public Usuario usuarioRegistradoPorId(@PathVariable("id") Integer id){
   try{ return usuarioService.findById(id).get();
   }catch(Exception e){
    return null;
   }
}

@DeleteMapping("/usuario/{id}")
public String deletarUsuario(@PathVariable("id") Integer id){
    try{
    usuarioService.deleteById(id);
    return "Usuario deletado com sucesso!!";
    }catch(Exception e){
        return "Não foi possivel deletar o usuario";
    }
}

@PutMapping("/usuario")
public Usuario atualizarUsuario(@RequestBody Usuario usuario){
    try{    
        Usuario usuarioBD = usuarioService.findById(usuario.getIdUsuario()).get();
        usuarioBD.setNome(usuario.getNome()); 
        usuarioBD.setSobrenome(usuario.getSobrenome());
        usuarioBD.setEmail(usuario.getEmail());
        usuarioBD.setSenha(usuario.getSenha());

        usuarioBD = usuarioService.save(usuarioBD);

        return usuarioBD; 
    }catch(Exception e){
        return null;
    }
}



@Autowired
private UsuarioService usuarioService;

}
