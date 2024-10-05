package com.softweek.softweek.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoDTO {

    private Long idProduto;

    private String nome;

    private String descricao;

    private Double preco;

    private Boolean ativo;

    private Long idSubcategoria;
}
