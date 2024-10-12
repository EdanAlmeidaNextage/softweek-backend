package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.CategoriaDTO;
import com.softweek.softweek.domain.model.Categoria;
import com.softweek.softweek.domain.repository.Categoriarepository;
import com.softweek.softweek.domain.service.CategoriaService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    private CategoriaDTO montaCategoriaDTO(Categoria categoria) {
        return CategoriaDTO.builder()
                .idCategoria(categoria.getIdCategoria())
                .nome(categoria.getNome())
                .build();
    }
}
