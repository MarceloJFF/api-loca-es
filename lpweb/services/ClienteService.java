package com.api.lpweb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.lpweb.dto.ClienteDTO;
import com.api.lpweb.model.Cliente;
import com.api.lpweb.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Page<ClienteDTO> findAllPaged(PageRequest pageRequest){
        Page<Cliente> list = repository.findAll(pageRequest);
        return list.map(x-> new ClienteDTO(x));
    }

    @Transactional
    public ClienteDTO findById(Long id){
        Optional<Cliente> obj = repository.findById(id);
        Cliente entity = obj.get();
        
        return new ClienteDTO(entity);

    }
    
    @Transactional
    public ClienteDTO insert(ClienteDTO dto){
        Cliente entity = new Cliente();
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setNome_cliente(dto.getNome_cliente());
        entity.setTelefone(dto.getTelefone());
        
        entity = repository.save(entity);
        return new ClienteDTO(entity);
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO dto){
        
        try {
            
        Cliente entity = repository.getReferenceById(id);// n toca no bd ainda, só depois de salvar
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setNome_cliente(dto.getNome_cliente());
        entity.setTelefone(dto.getTelefone());
        entity = repository.save(entity);
        return new ClienteDTO(entity); 
        
   
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


