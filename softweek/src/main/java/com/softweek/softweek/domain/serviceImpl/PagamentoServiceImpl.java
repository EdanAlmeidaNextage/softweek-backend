package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.PagamentoDTO;
import com.softweek.softweek.domain.model.Locacao;
import com.softweek.softweek.domain.model.Pagamento;
import com.softweek.softweek.domain.repository.LocacaoRepository;
import com.softweek.softweek.domain.repository.PagamentoRepository;
import com.softweek.softweek.domain.service.PagamentoService;
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
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final LocacaoRepository locacaoRepository;

    @Override
    public ResponseEntity<List<PagamentoDTO>> listarPagamentos() {
        try {
            List<Pagamento> pagamentos = pagamentoRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(pagamentos.stream()
                    .map(this::montaPagamentoDTO)
                    .toList());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar pagamentos: " + e.getMessage(), e);
        }
    }

    @Override
    public ResponseEntity<PagamentoDTO> salvarPagamento(PagamentoDTO pagamentoDTO) {
        Locacao locacao = locacaoRepository.findById(pagamentoDTO.getLocacaoId())
                .orElseThrow(() -> new EntityNotFoundException("Locação não encontrada"));

        Pagamento pagamento = Pagamento.builder()
                .locacao(locacao)
                .dataPagamento(new java.util.Date())
                .valorPago(pagamentoDTO.getValorPago())
                .metodoPagamento(pagamentoDTO.getMetodoPagamento())
                .build();

        pagamento = pagamentoRepository.save(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(montaPagamentoDTO(pagamento));
    }

    @Override
    public ResponseEntity<PagamentoDTO> atualizarPagamento(PagamentoDTO pagamentoDTO) {
        Pagamento pagamentoExistente = pagamentoRepository.findById(pagamentoDTO.getIdPagamento())
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado"));

        Locacao locacao = locacaoRepository.findById(pagamentoDTO.getLocacaoId())
                .orElseThrow(() -> new EntityNotFoundException("Locação não encontrada"));

        Pagamento pagamentoAtualizado = atualizarCamposPagamento(pagamentoDTO, pagamentoExistente);
        pagamentoAtualizado.setLocacao(locacao);

        pagamentoAtualizado = pagamentoRepository.save(pagamentoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(montaPagamentoDTO(pagamentoAtualizado));
    }

    @Override
    public ResponseEntity<Void> deletarPagamento(Long idPagamento) {
        Pagamento pagamentoExistente = pagamentoRepository.findById(idPagamento)
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado"));

        pagamentoRepository.delete(pagamentoExistente);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private PagamentoDTO montaPagamentoDTO(Pagamento pagamento) {
        return PagamentoDTO.builder()
                .idPagamento(pagamento.getIdPagamento())
                .locacaoId(pagamento.getLocacao().getIdLocacao())
                .dataPagamento(Utils.formataDataString(pagamento.getDataPagamento()))
                .valorPago(pagamento.getValorPago())
                .metodoPagamento(pagamento.getMetodoPagamento())
                .build();
    }

    private Pagamento atualizarCamposPagamento(PagamentoDTO pagamentoDTO, Pagamento pagamentoExistente) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Map<String, Object> pagamentoMap = objectMapper.convertValue(pagamentoDTO, Map.class);
        return (Pagamento) Utils.atualizarObjetos(Pagamento.class, pagamentoMap, pagamentoExistente);
    }
}
