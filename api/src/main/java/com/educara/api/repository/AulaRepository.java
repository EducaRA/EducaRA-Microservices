package com.educara.api.repository;

import com.educara.api.model.Aula;
import com.educara.api.model.dto.aula.AulaGetAllDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    @Query("SELECT a FROM Aula a WHERE a.disciplina.professor.email = :email AND a.ativo = true")
    Page<Aula> findAllByAtivoTrueAndProfessor(Pageable paginacao, @Param("email") String emailProfessor);

    @Query("SELECT a FROM Aula a WHERE a.codigo = :uuid")
    Aula getReferenceByCodigo(@Param("uuid") UUID uuid);
}
