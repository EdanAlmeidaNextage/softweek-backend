package com.softweek.softweek.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubcategoriaDTO {

    private Long idSubcategoria;

    private String nome;

    private Boolean ativo;

    private String cor;
}
