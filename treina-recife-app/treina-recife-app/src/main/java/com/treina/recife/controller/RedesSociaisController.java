package com.treina.recife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.treina.recife.model.RedesSociais;
import com.treina.recife.service.RedesSociaisService;


@RestController
public class RedesSociaisController {
    
    @PostMapping("/redes_sociais")
    public RedesSociais criarNovaRedeSocial(@RequestBody RedesSociais redesSociais) {
        return redesSociaisService.save(redesSociais);
    }
    @GetMapping("/redes_sociais")
    
    public List<RedesSociais> obterRedesSociais(){
        return redesSociaisService.findAll();
    }

    @GetMapping("/redes_sociais/{id}")
    public RedesSociais obterRedesSociaisPeloId(@PathVariable("id") long id){
        return redesSociaisService.findById(id).get();
    }

    @DeleteMapping("/redes_sociais/{id}")
    public String deletarRedesPeloId(@PathVariable ("id") long id){
        redesSociaisService.deleteById(id);

        return "Rede deletada!!";
    }

    @PutMapping("/redes_sociais")
    public RedesSociais atualizarRedes(@RequestBody RedesSociais redesSociais){

        RedesSociais redesBD = redesSociaisService.findById(redesSociais.getId()).get();

        redesBD.setNome(redesSociais.getNome());
        redesBD.setLink(redesSociais.getLink());

        redesBD = redesSociaisService.save(redesBD);
        return redesBD;
    }

    


    
    /* @PostMapping("/contatos")
    public Contato criarNovoContato(@RequestBody Contato contato) {
        return contatoService.save(contato);
    } */

    @Autowired
    private RedesSociaisService redesSociaisService;

}
