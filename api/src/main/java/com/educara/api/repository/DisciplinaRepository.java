package com.educara.api.repository;

import com.educara.api.model.disciplina.Disciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Page<Disciplina> findAllByAtivoTrue(Pageable paginacao);
}
