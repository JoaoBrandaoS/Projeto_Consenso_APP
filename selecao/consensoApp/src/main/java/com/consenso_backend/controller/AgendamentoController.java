package com.consenso_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consenso_backend.model.Agendamento;
import com.consenso_backend.service.AgendamentoService;


@RestController
public class AgendamentoController {
    

    @PostMapping("/agendamento")
    public Object novoAgendamento(@RequestBody Agendamento agendar){
       try{
            return  agendamentoService.save(agendar);
        }catch(Exception e){
            String erro = "Erro em adicionar novo agendamento";
            return erro;
        } 
    }

    @GetMapping("/agendamento")
    public List<Agendamento> agendamentoCadastrados(){
        return agendamentoService.findAll();
    }

    @GetMapping("/agendamento/{id}")
    public ResponseEntity<Agendamento> agendamentoUnico(@PathVariable("id") Integer id){
        
    return agendamentoService.findById(id).map(record -> ResponseEntity.ok().body(record))
     .orElse(ResponseEntity.notFound().build());
        }
        

    @DeleteMapping("/agendamento/{id}")
    public String deletarAgendamento(@PathVariable("id") Integer id){
        try{
            agendamentoService.deleteById(id);
            return "Agendamento deletado!!";
        }catch(Exception e){
            return "Falha ao deletar agendamento";
        }

    }

    @PutMapping("/agendamento")
    public Object atualizarAgendamento(@RequestBody Agendamento agendar){
        
        try{    
            Agendamento agendarBD = agendamentoService.findById(agendar.getIdAgendamento()).get();
            
            agendarBD.setData(agendar.getData());
            agendarBD.setHora(agendar.getHora());

            agendarBD = agendamentoService.save(agendarBD);

            return agendarBD;
        }catch(Exception e){
            String erro = "não foi possivel atualizar agendamento";
            return erro;
            
        }


    }




    @Autowired
    private AgendamentoService agendamentoService;


}
