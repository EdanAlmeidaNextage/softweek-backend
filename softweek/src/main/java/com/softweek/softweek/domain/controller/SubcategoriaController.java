package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.service.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping(value = "/listar-subcategorias")
    public ResponseEntity<?> listarSubcategorias() {
        try {
            ResponseEntity<?> response = subcategoriaService.listarSubcategorias();
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
