package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    ResponseEntity<List<ClienteDTO>> listarClientes();

    ResponseEntity<ClienteDTO> salvarCliente(ClienteDTO clienteDTO);

    ResponseEntity<ClienteDTO> atualizarCliente(ClienteDTO clienteDTO);

    ResponseEntity<Void> excluirCliente(Long idCliente);
}
