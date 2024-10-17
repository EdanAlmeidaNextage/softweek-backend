package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.CarroDTO;
import com.softweek.softweek.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> listarCarros() {
        return carroService.listarCarros();
    }

    @PostMapping
    public ResponseEntity<CarroDTO> salvarCarro(@RequestBody CarroDTO carroDTO) {
        return carroService.salvarCarro(carroDTO);
    }

    @PutMapping
    public ResponseEntity<CarroDTO> atualizarCarro(@RequestBody CarroDTO carroDTO) {
        return carroService.atualizarCarro(carroDTO);
    }

    @DeleteMapping("/{idCarro}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long idCarro) {
        return carroService.deletarCarro(idCarro);
    }
}
