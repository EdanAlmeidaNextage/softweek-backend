package com.softweek.softweek.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subcategoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Subcategoria implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubcategoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "cor", length = 30)
    private String cor;

    @OneToMany(mappedBy = "subcategoria", cascade =  CascadeType.ALL, orphanRemoval = true)
    private Set<Produto> produtos = new HashSet<>();
}
