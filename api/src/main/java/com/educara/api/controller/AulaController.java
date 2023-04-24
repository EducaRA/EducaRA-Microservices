package com.educara.api.controller;

import com.educara.api.model.dto.aula.AulaGetAllDto;
import com.educara.api.model.mapper.AulaMapper;
import com.educara.api.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @Autowired
    private AulaMapper mapper;

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"descricao"}) Pageable paginacao) {
        Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
        if(!(autenticado instanceof AnonymousAuthenticationToken)) {
            String emailProfessor = autenticado.getName();
            Page<AulaGetAllDto> page = repository.findAllByAtivoTrueAndProfessor(paginacao, emailProfessor).map(mapper::toGetAllDto);
            return ResponseEntity.ok(page);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

    @GetMapping("/{codigo}")
    public ResponseEntity detalhar(@PathVariable("codigo") UUID uuid) {
        var aula = repository.getReferenceByCodigo(uuid);
        return ResponseEntity.ok(mapper.toGetOneDto(aula));
    }


}
