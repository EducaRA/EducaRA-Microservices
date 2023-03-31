package com.educara.api.model.objetoEducacional;

import com.educara.api.model.aula.Aula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "objetos_educacionais")
@Entity(name = "ObjetoEducacional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ObjetoEducacional {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal escala;
    private String filehashMd5;
    private String path;
    private Integer size;
    private String extension;

    @ManyToOne
    @JoinColumn(name = "fk_aula_id", referencedColumnName = "id")
    private Aula aula;

}
