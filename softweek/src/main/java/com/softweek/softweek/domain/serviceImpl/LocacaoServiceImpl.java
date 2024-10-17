package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.LocacaoDTO;
import com.softweek.softweek.domain.model.Locacao;
import com.softweek.softweek.domain.repository.LocacaoRepository;
import com.softweek.softweek.domain.service.LocacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoServiceImpl implements LocacaoService {

    private final LocacaoRepository locacaoRepository;

    public LocacaoServiceImpl(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Override
    public ResponseEntity<List<LocacaoDTO>> listarLocacoes() {
        List<Locacao> locacoes = locacaoRepository.findAll();
        // Mapeie as locações para LocacaoDTO aqui (não incluído)
        return ResponseEntity.ok(/* Lista de LocacaoDTO */);
    }

    @Override
    public ResponseEntity<LocacaoDTO> salvarLocacao(LocacaoDTO locacaoDTO) {
        Locacao locacao = Locacao.builder()
                .dataInicio(locacaoDTO.getDataInicio())
                .dataFim(locacaoDTO.getDataFim())
                .carro(locacaoDTO.getCarro()) // Usando getCarro()
                .cliente(locacaoDTO.getCliente()) // Usando getCliente()
                .build();

        locacao = locacaoRepository.save(locacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(montaLocacaoDTO(locacao));
    }

    @Override
    public ResponseEntity<LocacaoDTO> atualizarLocacao(LocacaoDTO locacaoDTO) {
        // Implementação para atualizar locação (não incluído)
        return ResponseEntity.ok(/* Retorne LocacaoDTO atualizado */);
    }

    @Override
    public ResponseEntity<Void> deletarLocacao(Long idLocacao) {
        // Implementação para deletar locação (não incluído)
        return ResponseEntity.noContent().build();
    }

    private LocacaoDTO montaLocacaoDTO(Locacao locacao) {
        return LocacaoDTO.builder()
                .idLocacao(locacao.getIdLocacao())
                .dataInicio(locacao.getDataInicio())
                .dataFim(locacao.getDataFim())
                .carro(locacao.getCarro()) // Usando getCarro()
                .cliente(locacao.getCliente()) // Usando getCliente()
                .build();
    }
}
