package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.LocacaoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocacaoService {

    ResponseEntity<List<LocacaoDTO>> listarLocacoes();

    ResponseEntity<LocacaoDTO> salvarLocacao(LocacaoDTO locacaoDTO);

    ResponseEntity<LocacaoDTO> atualizarLocacao(LocacaoDTO locacaoDTO);

    ResponseEntity<Void> deletarLocacao(Long idLocacao);
}
