package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarroDTO {

    private Long idCarro;
    private String modelo;
    private String marca;
    private Integer ano;
    private String placa;
    private Double precoDiaria;
    private String dataCriacao;
    private String dataEdicao;
}
