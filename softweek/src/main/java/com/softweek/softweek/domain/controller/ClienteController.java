package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.ClienteDTO;
import com.softweek.softweek.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/listar")
    public ResponseEntity<?> listarClientes() {
        try {
            ResponseEntity<?> response = clienteService.listarClientes();
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<?> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ResponseEntity<?> response = clienteService.salvarCliente(clienteDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<?> atualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ResponseEntity<?> response = clienteService.atualizarCliente(clienteDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<?> excluirCliente(@RequestParam("idCliente") Long idCliente) {
        try {
            ResponseEntity<?> response = clienteService.excluirCliente(idCliente);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
