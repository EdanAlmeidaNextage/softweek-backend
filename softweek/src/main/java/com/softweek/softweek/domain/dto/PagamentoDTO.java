package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagamentoDTO {
    private Long idPagamento;
    private Long locacaoId;
    private Double valorPago;
    private String metodoPagamento;
    private String dataPagamento;
}
