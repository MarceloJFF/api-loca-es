package com.api.lpweb.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.lpweb.model.Aluguel;
import com.api.lpweb.model.Locacao;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AluguelDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dt_vencimento;
    private Double valor_pago;
    private String obs;
    private Locacao loc;

    public AluguelDTO(Aluguel entity){
        this.Id = entity.getId();
        this.dt_vencimento = entity.getDt_vencimento();
        this.loc = entity.getLocacao();
        this.valor_pago = entity.getValor_pago();
        this.obs = entity.getObs();
    }
}
