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
@Table(name = "categoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Categoria implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "cor", length = 30)
    private String cor;

    @OneToMany(mappedBy = "categoria", cascade =  CascadeType.ALL, orphanRemoval = true)
    private Set<Subcategoria> subcategorias = new HashSet<>();
}
