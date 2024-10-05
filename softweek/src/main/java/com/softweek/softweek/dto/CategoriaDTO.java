package com.softweek.softweek.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaDTO {

    private Long idCategoria;

    private String nome;

    private Boolean ativo;

    private String cor;
}
