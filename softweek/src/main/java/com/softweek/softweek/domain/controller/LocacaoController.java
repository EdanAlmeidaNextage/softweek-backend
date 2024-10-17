package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.LocacaoDTO;
import com.softweek.softweek.domain.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    // Listar todas as locações
    @GetMapping(value = "/listar-locacoes")
    public ResponseEntity<?> listarLocacoes() {
        try {
            ResponseEntity<?> response = locacaoService.listarLocacoes();
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Salvar uma nova locação
    @PostMapping(value = "/salvar-locacao")
    public ResponseEntity<?> salvarLocacao(@RequestBody LocacaoDTO locacaoDTO) {
        try {
            ResponseEntity<?> response = locacaoService.salvarLocacao(locacaoDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Atualizar os dados de uma locação existente
    @PutMapping(value = "/atualizar-locacao")
    public ResponseEntity<?> atualizarLocacao(@RequestBody LocacaoDTO locacaoDTO) {
        try {
            ResponseEntity<?> response = locacaoService.atualizarLocacao(locacaoDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Deletar uma locação pelo ID
    @DeleteMapping(value = "/deletar-locacao/{id}")
    public ResponseEntity<?> deletarLocacao(@PathVariable Long id) {
        try {
            return locacaoService.deletarLocacao(id); // Chamada corrigida
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
