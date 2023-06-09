package com.educara.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "aulas")
@Entity(name = "Aula")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aula {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private UUID codigo;
    private String observacao;
    private String turma;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "fk_disciplina_id", referencedColumnName = "id")
    private Disciplina disciplina;

    @OneToMany(mappedBy = "aula")
    private List<ObjetoEducacional> objetos;


}
