package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProdutoDTO {
    private Long idProduto; // ID do produto
    private String nome;    // Nome do produto
    private String descricao; // Descrição do produto
    private Double preco;   // Preço do produto
    private Date dataCriacao; // Data de criação do produto (adicionado)
    private Date dataEdicao;  // Data da última edição (opcional)
    private Boolean ativo;     // Status do produto (ativo ou não)
}
