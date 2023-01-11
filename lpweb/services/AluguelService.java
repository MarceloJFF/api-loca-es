package com.api.lpweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.lpweb.dto.AluguelDTO;
import com.api.lpweb.model.Aluguel;
import com.api.lpweb.repository.AluguelRepository;

import jakarta.transaction.Transactional;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository repository;

    
    @Transactional
    public Page<AluguelDTO> findAllPaged(PageRequest pageRequest){
        Page<Aluguel> list = repository.findAll(pageRequest);
        return list.map(x-> new AluguelDTO(x));
    }

    @Transactional
    public AluguelDTO findById(Long id){
        Optional<Aluguel> obj = repository.findById(id);
        Aluguel entity = obj.get();
        
        return new AluguelDTO(entity);

    }
    
    @Transactional
    public AluguelDTO insert(AluguelDTO dto){
        Aluguel entity = new Aluguel();
        entity.setDt_vencimento(dto.getDt_vencimento());
        entity.setLocacao(dto.getLoc());
        entity.setObs(dto.getObs());;
        entity.setValor_pago(dto.getValor_pago());
        
        entity = repository.save(entity);
        return new AluguelDTO(entity);
    }

    @Transactional
    public AluguelDTO update(Long id, AluguelDTO dto){
        
        try {
            
        Aluguel entity = repository.getReferenceById(id);// n toca no bd ainda, só depois de salvar
        
        entity.setDt_vencimento(dto.getDt_vencimento());
        entity.setLocacao(dto.getLoc());
        entity.setObs(dto.getObs());
        entity.setValor_pago(dto.getValor_pago());
        
        entity = repository.save(entity);
        return new AluguelDTO(entity); 
        
   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        } 
        return null;
    }

    public void delete(Long id){
        
        try {
            repository.deleteById(id);   
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Id not found");
            // TODO: handle exception
        }catch(DataIntegrityViolationException e){
            System.out.println("Integridade do bd"); //jogar exceção
        }
    }

}
