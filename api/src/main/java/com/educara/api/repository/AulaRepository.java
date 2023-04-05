package com.educara.api.repository;

import com.educara.api.model.Aula;
import com.educara.api.model.dto.aula.AulaGetAllDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    Page<Aula> findAllByAtivoTrue(Pageable paginacao);
    @Query("SELECT a FROM Aula a WHERE a.professor.email = :email")
    Page<Aula> findAllByAtivoTrueAndProfessor(Pageable paginacao, @Param("email") String emailProfessor);
}
