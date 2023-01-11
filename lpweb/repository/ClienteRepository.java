package com.api.lpweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lpweb.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
