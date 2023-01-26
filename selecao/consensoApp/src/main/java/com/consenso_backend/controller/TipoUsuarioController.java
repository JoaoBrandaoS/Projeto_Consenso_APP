package com.consenso_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
    public TipoUsuario adicionarTipoUsuario(@RequestBody TipoUsuario tipo){
        try{
        return tipoUsuarioService.save(tipo);

        }catch(Exception e){
        return null;

    }
    }

    @GetMapping("/tipousuario")
    public List<TipoUsuario> todosOsTiposUsuarios(){
      try{
        return tipoUsuarioService.findAll();
      }catch(Exception e){
        return null;
      }
    }

    @GetMapping("/tipousuario/{id}")
    public TipoUsuario unicoTipoUsuario(@PathVariable("id") Integer id){
        try{return tipoUsuarioService.findById(id).get();
        }catch(Exception a){
            return null;
        }
    
    }

    @DeleteMapping("/tipousuario/{id}")
    public String deletarUnicoUsuario(@PathVariable("id") Integer id){
       try{
        tipoUsuarioService.deleteById(id);
        return "Tipo usuario deletado";
       }catch(Exception e){
        return "Tipo de usuario não foi deletado";
       }
    }

    @PutMapping("/tipousuario")
    public TipoUsuario atualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuario){
        try{
        
            TipoUsuario tipoUsuarioBD = tipoUsuarioService.findById(tipoUsuario.getIdTipoUsuario()).get();

            tipoUsuarioBD.setNome(tipoUsuario.getNome());

            tipoUsuarioBD = tipoUsuarioService.save(tipoUsuarioBD);

            return tipoUsuarioBD;
        }catch(Exception e){
            return null;
        }
    }

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    
}
