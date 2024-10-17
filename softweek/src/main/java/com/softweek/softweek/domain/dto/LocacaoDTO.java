package com.softweek.softweek.domain.dto;

import com.softweek.softweek.domain.model.Carro;
import com.softweek.softweek.domain.model.Cliente;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LocacaoDTO {
    private Long idLocacao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Carro carro;
    private Cliente cliente;
}
