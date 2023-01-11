package com.api.lpweb.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dt_vencimento;
    private Double valor_pago;
    private String obs;
    

    @ManyToOne
    @JoinColumn(name = "id_loc")
    private Locacao locacao;

}
