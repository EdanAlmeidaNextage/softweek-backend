package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.VendaDTO;
import com.softweek.softweek.domain.model.Venda;
import com.softweek.softweek.domain.repository.VendaRepository;
import com.softweek.softweek.domain.service.VendaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;

    public VendaServiceImpl(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public ResponseEntity<List<VendaDTO>> listarVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(vendas.stream()
                .map(venda -> VendaDTO.builder()
                        .id(venda.getId())
                        .idCliente(venda.getIdCliente())
                        .idProdutos(venda.getIdProdutos())
                        .dataVenda(venda.getDataVenda())
                        .build()).toList());
    }

    @Override
    public ResponseEntity<VendaDTO> salvarVenda(VendaDTO vendaDTO) {
        Venda venda = Venda.builder()
                .idCliente(vendaDTO.getIdCliente())
                .idProdutos(vendaDTO.getIdProdutos())
                .dataVenda(vendaDTO.getDataVenda())
                .build();

        venda = vendaRepository.save(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(montaVendaDTO(venda));
    }

    @Override
    public ResponseEntity<VendaDTO> atualizarVenda(VendaDTO vendaDTO) {
        Venda vendaExistente = vendaRepository.findById(vendaDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada"));

        vendaExistente.setIdCliente(vendaDTO.getIdCliente());
        vendaExistente.setIdProdutos(vendaDTO.getIdProdutos());
        vendaExistente.setDataVenda(vendaDTO.getDataVenda());

        vendaExistente = vendaRepository.save(vendaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(montaVendaDTO(vendaExistente));
    }

    @Override
    public ResponseEntity<Void> excluirVenda(Long idVenda) {
        vendaRepository.deleteById(idVenda);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private VendaDTO montaVendaDTO(Venda venda) {
        return VendaDTO.builder()
                .id(venda.getId())
                .idCliente(venda.getIdCliente())
                .idProdutos(venda.getIdProdutos())
                .dataVenda(venda.getDataVenda())
                .build();
    }
}
