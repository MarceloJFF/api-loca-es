package com.api.lpweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.lpweb.model.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel,Long>{
    
}
