package com.softweek.softweek.domain.serviceImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softweek.softweek.domain.dto.ClienteDTO;
import com.softweek.softweek.domain.model.Cliente;
import com.softweek.softweek.domain.repository.ClienteRepository;
import com.softweek.softweek.domain.service.ClienteService;
import com.softweek.softweek.domain.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Data
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        try {
            List<Cliente> clientes = clienteRepository.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(clientes.stream()
                    .map(this::montaClienteDTO)
                    .toList());
        } catch (Exception e) {
            throw e; // Lançando exceção para ser tratada no controlador
        }
    }

    @Override
    public ResponseEntity<ClienteDTO> salvarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .nome(clienteDTO.getNome())
                .email(clienteDTO.getEmail())
                .telefone(clienteDTO.getTelefone())
                .documentoIdentidade(clienteDTO.getDocumentoIdentidade())
                .build();

        cliente = clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(montaClienteDTO(cliente));
    }

    @Override
    public ResponseEntity<ClienteDTO> atualizarCliente(ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(clienteDTO.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Cliente clienteAtualizado = atualizarCamposCliente(clienteDTO, clienteExistente);

        clienteAtualizado = clienteRepository.save(clienteAtualizado);

        return ResponseEntity.status(HttpStatus.OK).body(montaClienteDTO(clienteAtualizado));
    }

    @Override
    public ResponseEntity<Void> excluirCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private ClienteDTO montaClienteDTO(Cliente cliente) {
        return ClienteDTO.builder()
                .idCliente(cliente.getIdCliente())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .documentoIdentidade(cliente.getDocumentoIdentidade())
                .build();
    }

    private Cliente atualizarCamposCliente(ClienteDTO clienteDTO, Cliente clienteExistente) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Map<String, Object> clienteMap = objectMapper.convertValue(clienteDTO, Map.class);

        return (Cliente) Utils.atualizarObjetos(Cliente.class, clienteMap, clienteExistente);
    }
}
