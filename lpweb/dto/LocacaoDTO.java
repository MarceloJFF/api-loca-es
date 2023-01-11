package com.api.lpweb.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.lpweb.model.Aluguel;
import com.api.lpweb.model.Cliente;
import com.api.lpweb.model.Imovel;
import com.api.lpweb.model.Locacao;

import lombok.Data;


@Data
public class LocacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long Id;
    private Imovel id_imovel;
    private Cliente id_inquilino;
    private Integer ativo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_fim;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_inicio;
    private Integer dia_vencimento;
    private Double perc_multa;
    private Double valor_aluguel;
    private String obs;
   

    public LocacaoDTO(Locacao entity){
        this.id_imovel = entity.getImovel();
        this.id_inquilino = entity.getInquilino();
        this.ativo = entity.getAtivo();
        this.data_fim = entity.getData_fim();
        this.data_inicio = entity.getData_inicio();
        this.dia_vencimento = entity.getDia_vencimento();
        this.perc_multa = entity.getPerc_multa();
        this.valor_aluguel = entity.getValor_aluguel();
        this.obs = entity.getObs();
        
    }
}
