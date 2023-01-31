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
   return usuarioService.findAll();
   
}

@GetMapping("/usuario/{id}")
public ResponseEntity<Usuario> usuarioRegistradoPorId(@PathVariable("id") Integer id){
   
     return usuarioService.findById(id).map(record -> ResponseEntity.ok().body(record))
     .orElse(ResponseEntity.notFound().build());
   
   
}

@DeleteMapping("/usuario/{id}")
public ResponseEntity<Object> deletarUsuario(@PathVariable("id") Integer id){
    try{
    usuarioService.deleteById(id);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }catch(Exception e){
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}


@PutMapping("/usuario/{id}")
public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id ,@RequestBody Usuario usuario){
     return usuarioService.findByIdUsuario(id).map(record -> {
            record.setNome(usuario.getNome());
            record.setSobrenome(usuario.getSobrenome());
            record.setSenha(usuario.getSenha());
            record.setEmail(usuario.getEmail());
            Usuario updated = usuarioService.save(record);
            return ResponseEntity.ok().body(updated);
          }).orElse(ResponseEntity.notFound().build());
}



@Autowired
private UsuarioService usuarioService;

}
