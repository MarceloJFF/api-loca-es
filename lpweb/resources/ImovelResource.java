package com.api.lpweb.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.lpweb.dto.ImovelDTO;
import com.api.lpweb.services.ImovelService;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelResource {

    @Autowired
    private ImovelService service;

    @GetMapping
    public ResponseEntity<Page<ImovelDTO>> findAll(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction
        )
    {
        PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
        Page<ImovelDTO> list = service.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    
    @GetMapping(value = "/{id}") 
    public ResponseEntity<ImovelDTO> findById(@PathVariable Long id){
        ImovelDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ImovelDTO> insert(@RequestBody ImovelDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImovelDTO> update(@PathVariable long id, @RequestBody ImovelDTO dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
        
        
    }


}
