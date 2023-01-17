package com.treina.recife.service;

import org.aspectj.util.LangUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scripting.config.LangNamespaceHandler;

import com.treina.recife.model.DadosPessoas;

public interface DadosPessoasService extends JpaRepository<DadosPessoas, Long> {
    
}
