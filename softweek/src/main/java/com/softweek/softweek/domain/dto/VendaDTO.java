package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VendaDTO {
    private Long id; // ID da venda
    private Long idCliente; // ID do cliente que fez a compra
    private List<Long> idProdutos; // Lista de IDs dos produtos vendidos
    private String dataVenda; // Data da venda
}
