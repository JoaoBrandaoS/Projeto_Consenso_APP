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
    public Object adicionarTipoUsuario(@RequestBody TipoUsuario tipo){
        try{
        return tipoUsuarioService.save(tipo);

        }catch(Exception e){
            String erro = "Falha ao tentar adicionar novo tipo de usuario";
            return erro;

    }
    }

    @GetMapping("/tipousuario")
    public List<TipoUsuario> todosOsTiposUsuarios(){
        return tipoUsuarioService.findAll();
     
    }

    @GetMapping("/tipousuario/{id}")
    public Object unicoTipoUsuario(@PathVariable("id") Integer id){
        try{return tipoUsuarioService.findById(id).get();
        }catch(Exception a){
            String erro = "Falha ao tentar retornar tipo de usuario/ erro no caminho";
            return erro;
            
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
    public Object atualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuario){
        try{
        
            TipoUsuario tipoUsuarioBD = tipoUsuarioService.findById(tipoUsuario.getIdTipoUsuario()).get();

            tipoUsuarioBD.setNome(tipoUsuario.getNome());

            tipoUsuarioBD = tipoUsuarioService.save(tipoUsuarioBD);

            return tipoUsuarioBD;
        }catch(Exception e){
            String erro = "Falha ao tentar adicionar novo tipo de usuario";
            return erro;
        }
    }

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    
}
