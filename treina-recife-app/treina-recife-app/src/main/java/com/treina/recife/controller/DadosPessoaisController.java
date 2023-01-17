package com.treina.recife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.treina.recife.service.DadosPessoasService;
import com.treina.recife.model.DadosPessoas;

public class DadosPessoaisController {
    
    @PostMapping("/dadosPessoais")
    public DadosPessoas criarNovaRedeSocial(@RequestBody DadosPessoas dadosPessoais) {
        return dadosPessoasService.save(dadosPessoais);
    }
    @GetMapping("/dadosPessoais")
    public List<DadosPessoas> obterRedesSociais(){
        return dadosPessoasService.findAll();
    }

    @GetMapping("/dadosPessoais/{id}")
    public DadosPessoas obterRedesSociaisPeloId(@PathVariable("id") long id){
        return dadosPessoasService.findById(id).get();
    }

    @DeleteMapping("/dadosPessoas/{id}")
    public String deletarRedesPeloId(@PathVariable ("id") long id){
        dadosPessoasService.deleteById(id);

        return "dado deletado!!";
    }

    @PutMapping("/dadosPessoas")
    public DadosPessoas atualizarRedes(@RequestBody DadosPessoas dadosPessoais){

        DadosPessoas dadosBD = dadosPessoasService.findById(dadosPessoais.getId()).get();

        dadosBD.setCpf(dadosPessoais.getCpf());
        dadosBD.setRg(dadosPessoais.getRg());

        dadosBD = dadosPessoasService.save(dadosBD);

        return dadosBD;
    }
    @Autowired
    private DadosPessoasService dadosPessoasService;


    


    

}
