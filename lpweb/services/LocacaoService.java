package com.api.lpweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.lpweb.dto.LocacaoDTO;
import com.api.lpweb.model.Locacao;
import com.api.lpweb.repository.LocacaoRepository;

import jakarta.transaction.Transactional;
@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository repository;
    @Transactional
    public LocacaoDTO insert(LocacaoDTO dto){
        Locacao entity = new Locacao();
        entity.setAtivo(dto.getAtivo());
        entity.setData_fim(dto.getData_fim());
        entity.setData_inicio(dto.getData_inicio());
        entity.setDia_vencimento(dto.getDia_vencimento());
        entity.setPerc_multa(dto.getPerc_multa());
        entity.setValor_aluguel(dto.getValor_aluguel());
        entity.setObs(dto.getObs());
        entity.setImovel(dto.getId_imovel());
        entity.setInquilino(dto.getId_inquilino());
        entity = repository.save(entity);
        return new LocacaoDTO(entity);
    }

    @Transactional
    public Page<LocacaoDTO> findAllPaged(PageRequest pageRequest){
        Page<Locacao> list = repository.findAll(pageRequest);
        return list.map(x-> new LocacaoDTO(x));
    }
    
    @Transactional
    public LocacaoDTO findById(Long id){
        Optional<Locacao> obj = repository.findById(id);
        Locacao entity = obj.get();
        
        return new LocacaoDTO(entity);

    }
    
    @Transactional
    public LocacaoDTO update(Long id, LocacaoDTO dto){
        
        try {
            Locacao entity = repository.getReferenceById(id);
            entity.setAtivo(dto.getAtivo());
            entity.setData_fim(dto.getData_fim());
            entity.setData_inicio(dto.getData_inicio());
            entity.setDia_vencimento(dto.getDia_vencimento());
            entity.setPerc_multa(dto.getPerc_multa());
            entity.setValor_aluguel(dto.getValor_aluguel());
            entity.setObs(dto.getObs());
            entity.setImovel(dto.getId_imovel());
            entity.setInquilino(dto.getId_inquilino());
            
            entity = repository.save(entity);
        
        return new LocacaoDTO(entity); 
        
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
