package com.softweek.softweek.service;

import com.softweek.softweek.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {

    ResponseEntity<ProdutoDTO> salvarProduto(ProdutoDTO produtoDTO);

    ResponseEntity<String> excluirProduto(Long idProduto);

    ResponseEntity<List<ProdutoDTO>> listarProdutos(Long idSubcategoria);

}
