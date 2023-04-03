package com.educara.api.model.aula;

import com.educara.api.model.aula.Aula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    Page<Aula> findAllByAtivoTrue(Pageable paginacao);
}
