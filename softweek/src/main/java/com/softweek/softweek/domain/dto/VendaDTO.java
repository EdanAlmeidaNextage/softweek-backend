package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VendaDTO {
    private Long id;
    private Long idCliente;
    private List<Long> idProdutos; //
    private String dataVenda;
}
