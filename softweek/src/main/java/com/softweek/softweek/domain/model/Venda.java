package com.softweek.softweek.domain.model;

import com.softweek.softweek.domain.auditoria.Audit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "venda")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Venda extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID da venda

    @Column(name = "id_cliente")
    private Long idCliente; // ID do cliente que fez a compra

    @ElementCollection
    @Column(name = "id_produto")
    private List<Long> idProdutos; // Lista de IDs dos produtos vendidos

    @Column(name = "data_venda")
    private String dataVenda; // Data da venda
}
