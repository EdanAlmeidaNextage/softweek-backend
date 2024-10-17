package com.softweek.softweek.domain.model;

import com.softweek.softweek.domain.auditoria.Audit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "carro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Carro extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarro;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @Column(name = "marca", length = 50)
    private String marca;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "placa", length = 10)
    private String placa;

    @Column(name = "preco_diaria")
    private Double precoDiaria;
}
