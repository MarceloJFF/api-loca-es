package com.api.lpweb.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.lpweb.model.Cliente;
import com.api.lpweb.model.Locacao;

import lombok.Data;



@Data
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome_cliente;
    private String cpf;
    private String telefone;
    private String email;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    //private List<Locacao> loc = new ArrayList<>();


    public ClienteDTO(Long id, String nome_cliente, String cpf, String telefone, String email,
        LocalDate dataNascimento) {
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public ClienteDTO(Cliente entity){
        this.id = entity.getId();
        this.nome_cliente = entity.getNome_cliente();
        this.cpf = entity.getCpf();
        this.telefone = entity.getTelefone();
        this.email = entity.getEmail();
        this.dataNascimento = entity.getDataNascimento();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
