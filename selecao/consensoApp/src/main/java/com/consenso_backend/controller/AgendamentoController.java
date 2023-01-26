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

import com.consenso_backend.model.Agendamento;
import com.consenso_backend.service.AgendamentoService;
import com.consenso_backend.service.UsuarioService;

@RestController
public class AgendamentoController {
    

    @PostMapping("/agendamento")
    public Agendamento novoAgendamento(@RequestBody Agendamento agendar){
       try{
            return  agendamentoService.save(agendar);
        }catch(Exception e){
            return null;
        } 
    }

    @GetMapping("/agendamento")
    public List<Agendamento> agendamentoCadastrados(){
     try{    
        return agendamentoService.findAll();

     }catch(Exception e){
        return null;  
     }
    }

    @GetMapping("/agendamento/{id}")
    public Agendamento agendamentoUnico(@PathVariable("id") Integer id){
        try{
            return agendamentoService.findById(id).get();
        }catch(Exception e){
            return null;
        }
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
    public Agendamento atualizarAgendamento(@RequestBody Agendamento agendar){
        
        try{    
            Agendamento agendarBD = agendamentoService.findById(agendar.getIdAgendamento()).get();
            
            agendarBD.setData(agendar.getData());
            agendarBD.setHora(agendar.getHora());

            agendarBD = agendamentoService.save(agendarBD);

            return agendarBD;
        }catch(Exception e){
            return null;
            
        }


    }

    @GetMapping("/agendamento/usuario/{id}")
    public List<Agendamento> listaDeServicosUsuarios(@PathVariable("id") Integer id){
        return agendamentoService.findByIdUsuario(id);
    }


    @Autowired
    private AgendamentoService agendamentoService;


}
