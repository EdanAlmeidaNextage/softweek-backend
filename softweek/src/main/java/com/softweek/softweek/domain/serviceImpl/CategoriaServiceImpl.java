package com.softweek.softweek.domain.serviceImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softweek.softweek.domain.dto.CategoriaDTO;
import com.softweek.softweek.domain.model.Categoria;
import com.softweek.softweek.domain.repository.Categoriarepository;
import com.softweek.softweek.domain.service.CategoriaService;
import com.softweek.softweek.domain.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Data
public class CategoriaServiceImpl implements CategoriaService {

    private final Categoriarepository categoriarepository;

    @Override
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        try {
            List<Categoria> categorias = categoriarepository.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(categorias.stream()
                    .map(x -> CategoriaDTO.builder()
                    .idCategoria(x.getIdCategoria())
                    .nome(x.getNome())
                    .dataCriacao(Utils.formataDataString(x.getDataCriacao()))
                    .dataEdicao(Utils.formataDataString(x.getUltimaDataModificada()))
                    .ativo(x.getAtivo())
                    .build()).toList());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<CategoriaDTO> salvarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = Categoria.builder()
                .nome(categoriaDTO.getNome())
                .build();

        categoria = categoriarepository.save(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(montaCategoriaDTO(categoria));
    }

    @Override
    public ResponseEntity<CategoriaDTO> atualizarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoriaExistente = categoriarepository.findById(categoriaDTO.getIdCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));

        Categoria categoriaAtualizada = atualizarCamposCategoria(categoriaDTO, categoriaExistente);

        categoriaAtualizada = categoriarepository.save(categoriaAtualizada);

        return ResponseEntity.status(HttpStatus.OK).body(montaCategoriaDTO(categoriaAtualizada));
    }

    @Override
    public ResponseEntity<CategoriaDTO> deletarCategoria(Long categoriaDTO) {
        Optional<Categoria> categoriaOptional = categoriarepository.findById(categoriaDTO);

        if(categoriaOptional.isPresent()){
            categoriarepository.delete(categoriaOptional.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    private CategoriaDTO montaCategoriaDTO(Categoria categoria) {
        return CategoriaDTO.builder()
                .idCategoria(categoria.getIdCategoria())
                .nome(categoria.getNome())
                .ativo(categoria.getAtivo())
                .dataCriacao(Utils.formataDataString(categoria.getDataCriacao()))
                .dataEdicao(Utils.formataDataString(categoria.getUltimaDataModificada()))
                .build();
    }

    private Categoria atualizarCamposCategoria(CategoriaDTO categoriaDTO, Categoria categoriaExistente) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Map<String, Object> categoriaMap = objectMapper.convertValue(categoriaDTO, Map.class);

        return (Categoria) Utils.atualizarObjetos(Categoria.class, categoriaMap, categoriaExistente);
    }
}
