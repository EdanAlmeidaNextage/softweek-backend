package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.CarroDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarroService {

    ResponseEntity<List<CarroDTO>> listarCarros();

    ResponseEntity<CarroDTO> salvarCarro(CarroDTO carroDTO);

    ResponseEntity<CarroDTO> atualizarCarro(CarroDTO carroDTO);

    ResponseEntity<Void> deletarCarro(Long idCarro);
}
