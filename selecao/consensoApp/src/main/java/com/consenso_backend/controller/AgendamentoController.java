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
import com.consenso_backend.service.UsuarioService;


@RestController
public class AgendamentoController {
    
    
    @PostMapping("/agendamento")
    public ResponseEntity<Object> novoAgendamento(@RequestBody Agendamento agendar){
        try {
            Usuario user = usuarioService.findByIdUsuario(agendar.getUsuario().getIdUsuario()).get();
            if (agendar.getData() != null && agendar.getHora() != null
                && agendar.getUsuario().getIdUsuario() != null) {

                agendamentoService.save(agendar);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
            }
        } catch (RuntimeException erroLogin) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroLogin.getMessage());
        }
        return null;
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

    @GetMapping("/agendamento/usuario/{id}")
    public List<Agendamento>listadeAgendamentosPorId(@PathVariable Integer id){
        return agendamentoService.findByusuarioIdUsuario(id);
    }


    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private UsuarioService usuarioService;


}
