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

            return ResponseEntity.status(HttpStatus.OK).body(categorias.stream().map(x -> CategoriaDTO.builder()
                    .idCategoria(x.getIdCategoria())
                    .nome(x.getNome())
                    .cor(x.getCor())
                    .ativo(x.getAtivo())
                    .build()).toList());
        } catch (Exception e) {
            throw e;
        }


    }
}
