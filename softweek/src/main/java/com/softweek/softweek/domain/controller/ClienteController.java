package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.ClienteDTO;
import com.softweek.softweek.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clientes") // Adicionando prefixo para as rotas
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos os clientes
    @GetMapping
    public ResponseEntity<?> listarClientes() {
        try {
            ResponseEntity<?> response = clienteService.listarClientes();
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Salvar um novo cliente
    @PostMapping
    public ResponseEntity<?> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ResponseEntity<?> response = clienteService.salvarCliente(clienteDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Atualizar os dados de um cliente existente
    @PutMapping
    public ResponseEntity<?> atualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ResponseEntity<?> response = clienteService.atualizarCliente(clienteDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Deletar um cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        try {
            clienteService.excluirCliente(id); // Corrigido o método para excluir
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
