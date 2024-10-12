package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.CategoriaDTO;
import com.softweek.softweek.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping(value = "/listar-categorias")
    public ResponseEntity<?> listarCategorias() {
        try {
            ResponseEntity<?> response = categoriaService.listarCategorias();
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(value = "/salvar-categoria")
    public ResponseEntity<?> salvarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        try {
            ResponseEntity<?> response = categoriaService.salvarCategoria(categoriaDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(value = "/atualizar-categoria")
    public ResponseEntity<?> atualizarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        try {
            ResponseEntity<?> response = categoriaService.atualizarCategoria(categoriaDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
