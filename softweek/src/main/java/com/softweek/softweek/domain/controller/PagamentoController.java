package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.PagamentoDTO;
import com.softweek.softweek.domain.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;


    @GetMapping(value = "/listar-pagamentos")
    public ResponseEntity<?> listarPagamentos() {
        try {
            return pagamentoService.listarPagamentos();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping(value = "/salvar-pagamento")
    public ResponseEntity<?> salvarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        try {
            return pagamentoService.salvarPagamento(pagamentoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PutMapping(value = "/atualizar-pagamento")
    public ResponseEntity<?> atualizarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        try {
            return pagamentoService.atualizarPagamento(pagamentoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @DeleteMapping(value = "/deletar-pagamento/{id}")
    public ResponseEntity<?> deletarPagamento(@PathVariable Long id) {
        try {
            return pagamentoService.deletarPagamento(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
