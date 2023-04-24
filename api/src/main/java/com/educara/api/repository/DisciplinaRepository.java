package com.educara.api.repository;

import com.educara.api.model.Disciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Optional<Disciplina> findByCodigo(UUID codigo);

    @Query("SELECT d FROM Disciplina d WHERE d.professor.email = :email AND a.ativo = true)")
    Page<Disciplina> findAllByAtivoTrueAndProfessor(Pageable paginacao, @Param("email") String emailProfessor);
}
