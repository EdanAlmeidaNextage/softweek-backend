package com.softweek.softweek.service;

import com.softweek.softweek.dto.CategoriaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {

    ResponseEntity<List<CategoriaDTO>> listarCategorias();

}
