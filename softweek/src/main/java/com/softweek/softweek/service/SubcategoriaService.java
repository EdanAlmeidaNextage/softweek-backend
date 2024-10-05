package com.softweek.softweek.service;

import com.softweek.softweek.dto.SubcategoriaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubcategoriaService {

    ResponseEntity<List<SubcategoriaDTO>> listarSubcategorias();
}
