package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoriaDTO {

    private Long idCategoria;

    private String nome;

    private Boolean ativo;

    List<SubcategoriaDTO> subcategorias;
}
