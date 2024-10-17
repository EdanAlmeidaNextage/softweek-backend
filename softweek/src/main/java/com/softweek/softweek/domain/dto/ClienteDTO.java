package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

    private Long idCliente;
    private String nome;
    private String email;
    private String telefone;
    private String documentoIdentidade;
    private String dataCriacao;
    private String dataEdicao;
}
