package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.VendaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VendaService {

    ResponseEntity<List<VendaDTO>> listarVendas();

    ResponseEntity<VendaDTO> salvarVenda(VendaDTO vendaDTO);

    ResponseEntity<VendaDTO> atualizarVenda(VendaDTO vendaDTO);

    ResponseEntity<Void> excluirVenda(Long idVenda);
}
