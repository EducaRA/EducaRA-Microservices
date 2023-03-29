package com.educara.api.controller;

import com.educara.api.model.Usuario;
import com.educara.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public String findAll() {
        var optional = repository.findById(1L);
        if(optional.isEmpty())
            return null;
        return optional.get().getEmail();
    }

    @PostMapping
    public String get() {
        return "Hello World - POST";
    }

    @PutMapping
    public String put() {
        return "Hello World - PUT";
    }

    @DeleteMapping
    public String delete() {
        return "Hello World - DELETE";
    }

}
