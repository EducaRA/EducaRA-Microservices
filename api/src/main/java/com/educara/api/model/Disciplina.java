package com.educara.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Table(name = "disciplinas")
@Entity(name = "Disciplina")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Disciplina implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    private UUID codigo;
    private String imagem;
    private Boolean ativo;
    @ManyToOne
    @JoinColumn(name = "fk_professor_id", referencedColumnName = "id")
    private Usuario professor;

    public void excluir() {
        this.ativo = false;
    }
}
