package com.softweek.softweek.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "pagamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    @ManyToOne
    @JoinColumn(name = "locacao_id", nullable = false)
    private Locacao locacao;

    private Double valorPago;
    private String metodoPagamento;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
}
