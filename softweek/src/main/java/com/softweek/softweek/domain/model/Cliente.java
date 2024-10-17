package com.softweek.softweek.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String numero; // Adicionei o atributo 'numero'
    private String endereco; // Adicionei o atributo 'endereco'

    // Método para obter o nome completo
    public String getNomeCompleto() {
        if (this.nome != null) {
            return this.nome;
        }
        return ""; // Retorno padrão se o nome for nulo
    }

    // Adicione outros métodos conforme necessário
}
