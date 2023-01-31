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

import com.consenso_backend.model.TipoUsuario;
import com.consenso_backend.service.TipoUsuarioService;


@RestController
public class TipoUsuarioController {

    @PostMapping("/tipousuario")
    public ResponseEntity<Object> adicionarTipoUsuario(@RequestBody TipoUsuario tipo){
        try{

        return ResponseEntity.status(HttpStatus.CREATED).body(tipo);

        }catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
    }

    @GetMapping("/tipousuario")
    public List<TipoUsuario> todosOsTiposUsuarios(){
        return tipoUsuarioService.findAll();
     
    }

    @GetMapping("/tipousuario/{id}")
    public ResponseEntity<TipoUsuario> unicoTipoUsuario(@PathVariable("id") Integer id){

    return tipoUsuarioService.findById(id).map(record -> ResponseEntity.ok().body(record))
    .orElse(ResponseEntity.notFound().build());
        
    }

    @DeleteMapping("/tipousuario/{id}")
    public ResponseEntity<Object> deletarUnicoUsuario(@PathVariable("id") Integer id){
       try{
        tipoUsuarioService.deleteById(id);   
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
       }catch(Exception e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

    @PutMapping("/tipousuario/{id}")
    public ResponseEntity<TipoUsuario> atualizarTipoUsuario(@PathVariable Integer id ,@RequestBody TipoUsuario tipoUsuario){
          return tipoUsuarioService.findByIdTipoUsuario(id).map(record -> {
             record.setNome(tipoUsuario.getNome());
              TipoUsuario updated = tipoUsuarioService.save(record);
              return ResponseEntity.ok().body(updated);
          }).orElse(ResponseEntity.notFound().build());
    }

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    
}
