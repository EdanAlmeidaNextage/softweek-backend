package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.PagamentoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PagamentoService {
    ResponseEntity<List<PagamentoDTO>> listarPagamentos();

    ResponseEntity<PagamentoDTO> salvarPagamento(PagamentoDTO pagamentoDTO);

    ResponseEntity<PagamentoDTO> atualizarPagamento(PagamentoDTO pagamentoDTO);

    ResponseEntity<Void> excluirPagamento(Long idPagamento);
}
