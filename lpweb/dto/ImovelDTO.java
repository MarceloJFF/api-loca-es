package com.api.lpweb.dto;

import java.util.ArrayList;
import java.util.List;

import com.api.lpweb.model.Imovel;
import com.api.lpweb.model.Locacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImovelDTO {
    private static final long serialVersionUID = 1L;
 
    private Long id;
    private String tipo_imovel;
    private String endereco;
    private String cep;
    private Integer dormitorios;
    private Integer banheiros;
    private Integer suites;
    private Integer metragem;
    private Double valor_aluguel;
    private String obs;
    //private List<Locacao> locacoes = new ArrayList<>();


    public ImovelDTO(Imovel entity){
        this.id = entity.getId();
        this.tipo_imovel = entity.getTipo_imovel();
        this.endereco = entity.getEndereco();
        this.cep = entity.getCep();
        this.dormitorios = entity.getDormitorios();
        this.banheiros = entity.getBanheiros();
        this.suites = entity.getSuites();
        this.metragem = entity.getMetragem();
        this.valor_aluguel = entity.getValor_aluguel();
        this.obs = entity.getObs();
    }
}
