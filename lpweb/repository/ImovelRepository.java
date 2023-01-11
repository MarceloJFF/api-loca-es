package com.api.lpweb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lpweb.model.Imovel;


@Repository
public interface ImovelRepository extends JpaRepository<Imovel,Long> {
    
}
