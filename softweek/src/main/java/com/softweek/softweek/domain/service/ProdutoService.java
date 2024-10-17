package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {

    ResponseEntity<List<ProdutoDTO>> listarProdutos();

    ResponseEntity<ProdutoDTO> salvarProduto(ProdutoDTO produtoDTO);

    ResponseEntity<ProdutoDTO> atualizarProduto(ProdutoDTO produtoDTO);

    ResponseEntity<Void> excluirProduto(Long idProduto);
}
