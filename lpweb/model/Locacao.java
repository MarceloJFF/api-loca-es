package com.api.lpweb.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity 
@Table(name = "tb_locacao")
public class Locacao implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @ManyToOne
    @JoinColumn(name = "id_imo")
    private Imovel imovel;
    
    @ManyToOne
    @JoinColumn(name = "id_inqui")
    private Cliente inquilino;

    
    @OneToMany(mappedBy = "locacao" )
    private List<Aluguel> al  = new ArrayList<>();

    private Integer ativo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_fim;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_inicio;
    private Integer dia_vencimento;
    private Double perc_multa;
    private Double valor_aluguel;
    private String obs;


}
