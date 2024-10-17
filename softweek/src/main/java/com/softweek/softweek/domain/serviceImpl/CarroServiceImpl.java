package com.softweek.softweek.domain.serviceImpl;

import com.softweek.softweek.domain.dto.CarroDTO;
import com.softweek.softweek.domain.model.Carro;
import com.softweek.softweek.domain.repository.CarroRepository;
import com.softweek.softweek.domain.service.CarroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;

    public CarroServiceImpl(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public ResponseEntity<List<CarroDTO>> listarCarros() {
        // Lógica para listar carros
        List<Carro> carros = carroRepository.findAll();
        // Converta para DTO e retorne
        return ResponseEntity.ok(carros.stream().map(carro ->
                CarroDTO.builder()
                        .idCarro(carro.getIdCarro()) // Corrigido aqui
                        .modelo(carro.getModelo())
                        .marca(carro.getMarca())
                        .build()
        ).toList());
    }

    @Override
    public ResponseEntity<CarroDTO> salvarCarro(CarroDTO carroDTO) {
        // Lógica para salvar carro
        Carro carro = Carro.builder()
                .modelo(carroDTO.getModelo())
                .marca(carroDTO.getMarca())
                .build();
        carro = carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(montaCarroDTO(carro));
    }

    @Override
    public ResponseEntity<CarroDTO> atualizarCarro(CarroDTO carroDTO) {
        // Lógica para atualizar carro
        Carro carroExistente = carroRepository.findById(carroDTO.getIdCarro()) // Corrigido aqui
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        carroExistente.setModelo(carroDTO.getModelo());
        carroExistente.setMarca(carroDTO.getMarca());
        carroRepository.save(carroExistente);
        return ResponseEntity.ok(montaCarroDTO(carroExistente));
    }

    @Override
    public ResponseEntity<Void> deletarCarro(Long id) {
        // Lógica para deletar carro
        carroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private CarroDTO montaCarroDTO(Carro carro) {
        return CarroDTO.builder()
                .idCarro(carro.getIdCarro()) // Corrigido aqui
                .modelo(carro.getModelo())
                .marca(carro.getMarca())
                .build();
    }
}
