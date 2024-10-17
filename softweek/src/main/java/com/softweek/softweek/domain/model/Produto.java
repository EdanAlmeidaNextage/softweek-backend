package com.softweek.softweek.domain.model;

import com.softweek.softweek.domain.auditoria.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Produto extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "data_criacao", updatable = false)
    private Date dataCriacao;

    @Column(name = "data_edicao")
    private Date dataEdicao;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_subcategoria")
    private Subcategoria subcategoria;
}
