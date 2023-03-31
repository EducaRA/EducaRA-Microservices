package com.educara.api.repository;

import com.educara.api.model.objetoEducacional.ObjetoEducacional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetoEducacionalRepository extends JpaRepository<ObjetoEducacional, Long> {
    Page<ObjetoEducacional> findAllByAtivoTrue(Pageable paginacao);
}
