package com.consenso_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
       
        try{
            Usuario user = usuarioService.findByIdUsuario(servico.getUsuario().getIdUsuario()).get();
            if(user.getTipoUsuario().getIdTipoUsuario() == 2 && servico.getNome() != null && servico.getDescricao() != null
            && servico.getUsuario().getIdUsuario() != null ){
            servicoService.save(servico); 
            return ResponseEntity.status(HttpStatus.CREATED).body(servico);
           }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(servico.getUsuario().getNome());
            }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }

    @GetMapping("/servico")
    public List<Servico> todosServicos(){
            return servicoService.findAll();
       
    }

    @GetMapping("/servico/{id}")
    public Object servicoPorId(@PathVariable("id") Integer id){
       return servicoService.findById(id).map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @DeleteMapping("/servico/{id}")
    public ResponseEntity<Object> deletarServico(@PathVariable("id") Integer id){
       try{
        servicoService.deleteById(id);   
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
       }catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

    @CrossOrigin
    @PutMapping("/servico/{id}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Integer id, @RequestBody Servico servico){
       
        return servicoService.findByIdServico(id).map(record -> {
			record.setNome(servico.getNome());
			record.setDescricao(servico.getDescricao());
			Servico updated = servicoService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/servico/usuario/{id}")
    public List<Servico> listadeServicosPorID(@PathVariable Integer id){
        return servicoService.findServicoByusuarioIdUsuario(id);
    }

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioService usuarioService;


}
