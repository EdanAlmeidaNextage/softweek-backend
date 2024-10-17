package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.VendaDTO;
import com.softweek.softweek.domain.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarVendas() {
        return vendaService.listarVendas();
    }

    @PostMapping
    public ResponseEntity<VendaDTO> salvarVenda(@RequestBody VendaDTO vendaDTO) {
        return vendaService.salvarVenda(vendaDTO);
    }

    @PutMapping
    public ResponseEntity<VendaDTO> atualizarVenda(@RequestBody VendaDTO vendaDTO) {
        return vendaService.atualizarVenda(vendaDTO);
    }

    @DeleteMapping("/{idVenda}")
    public ResponseEntity<Void> excluirVenda(@PathVariable Long idVenda) {
        return vendaService.excluirVenda(idVenda);
    }
}
