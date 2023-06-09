package com.educara.api.model;

import com.educara.api.model.Aula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "objetos_educacionais")
@Entity(name = "ObjetoEducacional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ObjetoEducacional {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID codigo;
    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal escala;
    @Column(name = "filehash_md5")
    private String filehashMd5;
    private String caminho;
    @Column(name = "tamanho_megabyte")
    private Integer tamanhoMegabyte;
    private String extensao;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "fk_aula_id", referencedColumnName = "id")
    private Aula aula;

}
