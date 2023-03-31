package com.educara.api.model.aula;

import com.educara.api.model.disciplina.Disciplina;
import com.educara.api.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String codigo;
    private String observacao;
    private String turma;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "fk_professor_id", referencedColumnName = "id")
    private Usuario professor;

    @ManyToOne
    @JoinColumn(name = "fk_disciplina_id", referencedColumnName = "id")
    private Disciplina disciplina;


}
