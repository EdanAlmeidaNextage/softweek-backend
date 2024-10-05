package com.softweek.softweek.controller;

import com.softweek.softweek.dto.ProdutoDTO;
import com.softweek.softweek.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/salvar-produto")
    public ResponseEntity<?> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            ResponseEntity<?> response = produtoService.salvarProduto(produtoDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deletar-produto")
    public ResponseEntity<?> excluirProduto(@RequestParam("idProduto") Long idProduto) {
        try {
            ResponseEntity<?> response = produtoService.excluirProduto(idProduto);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/listar-produtos")
    public ResponseEntity<?> listarProdutos(@RequestParam("idSubcategoria") Long idSubcategoria) {
        try {
            ResponseEntity<?> response = produtoService.listarProdutos(idSubcategoria);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



}
