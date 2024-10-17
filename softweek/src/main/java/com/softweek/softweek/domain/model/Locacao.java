package com.softweek.softweek.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "locacao")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocacao;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
