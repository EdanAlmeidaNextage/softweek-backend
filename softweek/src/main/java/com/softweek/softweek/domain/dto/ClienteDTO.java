package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {
    private Long id;
    private String nome;
    private String numero;
    private String endereco;
}
