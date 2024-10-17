package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {
    private Long id; // ID do cliente
    private String nome; // Nome do cliente
    private String numero; // Número de contato
    private String endereco; // Endereço do cliente
}
