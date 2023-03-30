package com.educara.api.controller;

import com.educara.api.model.disciplina.*;
import com.educara.api.repository.DisciplinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDisciplina dados, UriComponentsBuilder uriBuilder) {
        var disciplina = new Disciplina(dados);
        repository.save(disciplina);

        var uri = uriBuilder.path("/disciplinas/{id}").buildAndExpand(disciplina.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoDisciplina(disciplina));
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
            var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemDisciplina::new);
            return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoDisciplina dados) {
        var disciplina = repository.getReferenceById(dados.id());
        disciplina.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplina));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var disciplina = repository.getReferenceById(id);
        disciplina.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var disciplina = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplina));
    }


}
