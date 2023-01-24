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

import com.consenso_backend.model.Agendamento;
import com.consenso_backend.model.Usuario;
import com.consenso_backend.service.AgendamentoService;

@RestController
public class AgendamentoController {
    

    @PostMapping("/agendamento")
    public ResponseEntity<Object> novoAgendamento(@RequestBody Agendamento agendar){
        Usuario pessoa = new Usuario();

        if(pessoa.getTipoUsuario().getIdTipoUsuario() == 1){
            agendamentoService.save(agendar);

            return ResponseEntity.status(HttpStatus.CREATED).body(agendar);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pessoa.getServicos().getNome());
        
    }

    @GetMapping("/agendamento")
    public List<Agendamento> agendamentoCadastrados(){
        return agendamentoService.findAll();
    }

    @GetMapping("/agendamento/{id}")
    public Agendamento agendamentoUnico(@PathVariable("id") Integer id){
        return agendamentoService.findById(id).get();
    }

    @DeleteMapping("/agendamento/{id}")
    public String deletarAgendamento(@PathVariable("id") Integer id){
        agendamentoService.deleteById(id);
        return "Agendamento deletado!!";
    }

    @PutMapping("/agendamento")
    public Agendamento atualizarAgendamento(@RequestBody Agendamento agendar){
        Agendamento agendarBD = agendamentoService.findById(agendar.getIdAgendamento()).get();
        
        agendarBD.setData(agendar.getData());
        agendarBD.setHora(agendar.getHora());

        agendarBD = agendamentoService.save(agendarBD);

        return agendarBD;
    
    }


    @Autowired
    private AgendamentoService agendamentoService;

}
