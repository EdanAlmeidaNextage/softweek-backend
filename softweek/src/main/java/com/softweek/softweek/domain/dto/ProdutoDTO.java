package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProdutoDTO {
    private Long idProduto;
    private String nome;
    private String descricao;
    private Double preco;
    private Date dataCriacao;
    private Date dataEdicao;
    private Boolean ativo;
}
