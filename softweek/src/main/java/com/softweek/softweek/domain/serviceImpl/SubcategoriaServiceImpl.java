package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.SubcategoriaDTO;
import com.softweek.softweek.domain.model.Subcategoria;
import com.softweek.softweek.domain.repository.SubcategoriaRepository;
import com.softweek.softweek.domain.service.SubcategoriaService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SubcategoriaServiceImpl implements SubcategoriaService {

    private final SubcategoriaRepository subcategoriaRepository;


    @Override
    public ResponseEntity<List<SubcategoriaDTO>> listarSubcategorias() {
        try {

            List<Subcategoria> subcategorias = subcategoriaRepository.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(subcategorias.stream().map(x -> SubcategoriaDTO.builder()
                    .idSubcategoria(x.getIdSubcategoria())
                    .nome(x.getNome())
                    .cor(x.getCor())
                    .ativo(x.getAtivo())
                    .build()).toList());

        } catch (Exception e) {
            throw e;
        }
    }
}
