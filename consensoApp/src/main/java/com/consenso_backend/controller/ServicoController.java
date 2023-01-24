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

import com.consenso_backend.model.Servico;
import com.consenso_backend.model.Usuario;
import com.consenso_backend.service.ServicoService;
import com.consenso_backend.service.UsuarioService;

@RestController
public class ServicoController {
    

    @PostMapping("/servico")
    public ResponseEntity<Object> criarNovoServico(@RequestBody Servico servico){
        Usuario user = usuarioService.findById(servico.getUsuario().getIdUsuario()).get();
        if(user.getTipoUsuario().getIdTipoUsuario() == 2){
        servicoService.save(servico); 
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
     }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(servico.getUsuario().getNome());
    }

    @GetMapping("/servico")
    public List<Servico> todosServicos(){
        return servicoService.findAll();
    }

    @GetMapping("/servico/{id}")
    public Servico servicoPorId(@PathVariable("id") Integer id){
        return servicoService.findById(id).get();
    }

    @DeleteMapping("/servico/{id}")
    public String deletarServico(@PathVariable("id") Integer id){
        servicoService.deleteById(id);
        
        return "Serviço deletado com sucesso";
    }

    @PutMapping("/servico")
    public Servico atualizarServico(@RequestBody Servico servico){
        Servico servicoBD = servicoService.findById(servico.getIdServico()).get();

        servicoBD.setNome(servico.getNome());
        servicoBD.setDescricao(servico.getDescricao());

        servicoBD = servicoService.save(servicoBD);

        return servicoBD;
    }

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioService usuarioService;


}
