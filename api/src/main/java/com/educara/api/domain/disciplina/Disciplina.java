package com.educara.api.domain.disciplina;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "disciplinas")
@Entity(name = "Disciplina")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Disciplina {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    private String imagem;
    private Boolean ativo;

    public Disciplina(DadosCadastroDisciplina dados) {
        this.ativo = Boolean.TRUE;
        this.nome = dados.nome();
        this.sigla = dados.sigla();
        this.imagem = dados.imagem();
    }

    public void atualizarInformacoes(DadosAtualizacaoDisciplina dados) {
        this.id = dados.id();
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.sigla() != null) {
            this.nome = dados.imagem();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
