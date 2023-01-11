package com.api.lpweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.lpweb.dto.ImovelDTO;
import com.api.lpweb.model.Imovel;
import com.api.lpweb.repository.ImovelRepository;

import jakarta.transaction.Transactional;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository repository;

    
    @Transactional
    public Page<ImovelDTO> findAllPaged(PageRequest pageRequest){
        Page<Imovel> list = repository.findAll(pageRequest);
        return list.map(x-> new ImovelDTO(x));
    }

    
    @Transactional
    public ImovelDTO findById(Long id){
        Optional<Imovel> obj = repository.findById(id);
        Imovel entity = obj.get();
        
        return new ImovelDTO(entity);

    }
    
    @Transactional
    public ImovelDTO insert(ImovelDTO dto){
        Imovel entity = new Imovel();
        entity.setBanheiros(dto.getBanheiros());
        entity.setCep(dto.getCep());
        entity.setDormitorios(dto.getDormitorios());
        entity.setEndereco(dto.getEndereco());
        entity.setMetragem(dto.getMetragem());
        entity.setObs(dto.getObs());
        entity.setSuites(dto.getSuites());
        entity.setTipo_imovel(dto.getTipo_imovel());
        entity.setValor_aluguel(dto.getValor_aluguel());
        
    
        entity = repository.save(entity);
        return new ImovelDTO(entity);
    }

    @Transactional
    public ImovelDTO update(Long id, ImovelDTO dto){
        
        try {
            
        Imovel entity = repository.getReferenceById(id);// n toca no bd ainda, só depois de salvar
        entity.setBanheiros(dto.getBanheiros());
        entity.setCep(dto.getCep());
        entity.setDormitorios(dto.getDormitorios());
        entity.setEndereco(dto.getEndereco());
        entity.setMetragem(dto.getMetragem());
        entity.setObs(dto.getObs());
        entity.setSuites(dto.getSuites());
        entity.setTipo_imovel(dto.getTipo_imovel());
        entity.setValor_aluguel(dto.getValor_aluguel());
        entity = repository.save(entity);
        return new ImovelDTO(entity); 
    
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
