package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.ProdutoDTO;
import com.softweek.softweek.domain.model.Produto;
import com.softweek.softweek.domain.repository.ProdutoRepository;
import com.softweek.softweek.domain.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos.stream()
                .map(produto -> ProdutoDTO.builder()
                        .idProduto(produto.getIdProduto())
                        .nome(produto.getNome())
                        .descricao(produto.getDescricao())
                        .preco(produto.getPreco())
                        .dataCriacao(produto.getDataCriacao())
                        .dataEdicao(produto.getDataEdicao())
                        .ativo(produto.getAtivo())
                        .build()).toList());
    }


    @Override
    public ResponseEntity<ProdutoDTO> salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = Produto.builder()
                .nome(produtoDTO.getNome())
                .descricao(produtoDTO.getDescricao())
                .preco(produtoDTO.getPreco())
                .dataCriacao(produtoDTO.getDataCriacao())
                .build();

        produto = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(montaProdutoDTO(produto));
    }

    @Override
    public ResponseEntity<ProdutoDTO> atualizarProduto(ProdutoDTO produtoDTO) {
        // Aqui você deve implementar a lógica para atualizar o produto
        // ...
        return ResponseEntity.status(HttpStatus.OK).body(produtoDTO); // Exemplo de retorno
    }

    @Override
    public ResponseEntity<Void> excluirProduto(Long idProduto) {
        produtoRepository.deleteById(idProduto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private ProdutoDTO montaProdutoDTO(Produto produto) {
        return ProdutoDTO.builder()
                .idProduto(produto.getIdProduto())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .preco(produto.getPreco())
                .dataCriacao(produto.getDataCriacao())
                .dataEdicao(produto.getDataEdicao())
                .ativo(produto.getAtivo())
                .build();
    }
}
