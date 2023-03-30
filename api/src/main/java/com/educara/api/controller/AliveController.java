package com.educara.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AliveController {
    @GetMapping
    public ResponseEntity alive() {
        return ResponseEntity.ok("ALIVE API");
    }

}
