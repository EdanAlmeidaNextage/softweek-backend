package com.softweek.softweek.serviceImpl;

import com.softweek.softweek.dto.ProdutoDTO;
import com.softweek.softweek.model.Produto;
import com.softweek.softweek.model.Subcategoria;
import com.softweek.softweek.repository.ProdutoRepository;
import com.softweek.softweek.repository.SubcategoriaRepository;
import com.softweek.softweek.service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    SubcategoriaRepository subcategoriaRepository;

    @Override
    public ResponseEntity<ProdutoDTO> salvarProduto(ProdutoDTO produtoDTO) {
        try {

            Subcategoria subcategoria = subcategoriaRepository.findById(produtoDTO.getIdSubcategoria())
                    .orElseThrow(() -> new EntityNotFoundException("Subcategoria não encontrada"));

            Produto produto = Produto.builder()
                    .nome(produtoDTO.getNome())
                    .descricao(produtoDTO.getDescricao())
                    .preco(produtoDTO.getPreco())
                    .ativo(true)
                    .subcategoria(subcategoria)
                    .build();

            produto = produtoRepository.save(produto);

            return ResponseEntity.status(HttpStatus.CREATED).body(montaProdutoDTO(produto));

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<String> excluirProduto(Long idProduto) {
        try {

            Produto produto = produtoRepository.findById(idProduto)
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

            produto.setAtivo(false);
            produtoRepository.save(produto);

            return ResponseEntity.ok("Produto excluído com sucesso!");

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(Long idSubcategoria) {
        try {

            List<Produto> produtos = produtoRepository.findAllBySubcategoriaIdSubcategoriaAndAtivoTrue(idSubcategoria);

            if (!produtos.isEmpty()) {
                List<ProdutoDTO> produtosDTO = produtos.stream()
                        .map(this::montaProdutoDTO)
                        .toList();
                return ResponseEntity.status(HttpStatus.OK).body(produtosDTO);
            } else {
                throw new EntityNotFoundException();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    private ProdutoDTO montaProdutoDTO(Produto produto) {
        return ProdutoDTO.builder()
                .idProduto(produto.getIdProduto())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .descricao(produto.getDescricao())
                .idSubcategoria(produto.getSubcategoria().getIdSubcategoria())
                .build();
    }
}
