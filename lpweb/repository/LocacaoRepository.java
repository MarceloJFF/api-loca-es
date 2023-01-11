package com.api.lpweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.lpweb.model.Locacao;

public interface LocacaoRepository extends JpaRepository <Locacao,Long>{
    
}
