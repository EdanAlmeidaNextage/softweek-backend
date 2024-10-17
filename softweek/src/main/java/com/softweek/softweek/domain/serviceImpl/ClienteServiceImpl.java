package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.ClienteDTO;
import com.softweek.softweek.domain.model.Cliente;
import com.softweek.softweek.domain.repository.ClienteRepository;
import com.softweek.softweek.domain.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientes.stream()
                .map(cliente -> ClienteDTO.builder()
                        .id(cliente.getId())
                        .nome(cliente.getNome())
                        .numero(cliente.getNumero()) // Aqui deve corresponder ao método getNumero()
                        .endereco(cliente.getEndereco()) // Aqui deve corresponder ao método getEndereco()
                        .build()).toList());
    }

    @Override
    public ResponseEntity<ClienteDTO> salvarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .nome(clienteDTO.getNome())
                .numero(clienteDTO.getNumero()) // Atributo adicionado
                .endereco(clienteDTO.getEndereco()) // Atributo adicionado
                .build();

        cliente = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(montaClienteDTO(cliente));
    }

    @Override
    public ResponseEntity<ClienteDTO> atualizarCliente(ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(clienteDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setNumero(clienteDTO.getNumero());
        clienteExistente.setEndereco(clienteDTO.getEndereco());

        clienteExistente = clienteRepository.save(clienteExistente);
        return ResponseEntity.status(HttpStatus.OK).body(montaClienteDTO(clienteExistente));
    }

    @Override
    public ResponseEntity<Void> excluirCliente(Long idCliente) {
        return null;
    }

    private ClienteDTO montaClienteDTO(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .numero(cliente.getNumero()) // Atributo adicionado
                .endereco(cliente.getEndereco()) // Atributo adicionado
                .build();
    }
}
